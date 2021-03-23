## Background
When data is sent downstream to receivers, we encode that data via one of our serializers. 
Each serializer will need maintenance and changes as more receivers come onboard. This work 
has been manageable thus far because we do not have many receivers, but as the complexity of 
customization grows, and the number of downstream receivers climbs, we will run into situations 
where a change for one receiver can potentially impact a receiver in production.

Two such examples that currently being managed by flag are:
- Texas requested that all AOE questions be defaulted to `UNK` if there's no value for them
- Ohio requested that we suppress two fields for them:
    - `OBR-23-11` completely
    - `QST` at the end of each AOE question
    
While both of these were easy to accomplish with flags, there is going to come a point where 
some change to the output of a serializer is going to cause bugs for receivers.

Looking into the future, several states have started to request using ReportStream for other types 
of ELR including things like the flu, STD's, heavy metals, etc and there has also been some 
discussion about being able to route vaccine records through ReportStream.

All of these changes present the potential for disruptions for receivers.

## Goals
- Give us a way to continue doing work on the serializers that will not affect downstream receivers 
  until we opt them into receiving the newer version

## Proposal
I propose that extract out the logic in the HL7 Serializer into a set of services, and we then 
annotate those services with a version number. Those version numbers will work in a similar fashion 
to how REST APIs do versioning. When the serializer is called, one of the translation 
configuration options is the version of the serializer to invoke. The serializer will then get 
the correct version of the serializer services matching the request. As we push a change 
to clients, we can set up each client with a test version that can invoke the newer version, and 
they are able to test and verify the changes at their own pace without disrupting their ability to 
receive the version they've already signed off on.

There are a few ways that this could be accomplished, and I'm not particularly beholden to one particular 
paradigm.

For example, we could add a version param to methods where logic is starting to bifurcate:

```kotlin
fun setTelephoneComponent(terser: Terser, value: String, pathSpec: String, element: Element, version: String = "1.0") {
    when (version) {
        "1.0" -> invokeV1()
        "2.0" -> invokeV2()
    }
}
```

Another possible way to manage it would be to create completely different versions of the serializer, and then instantiate them based on the translation configuration.
```kotlin
interface Serializer

class Hl7Serializer: Serializer {
    
}

class Hl7Serializerv11: Serializer {
    
}

fun hl7SerializerFactory(version: String = "1.0"): Serializer {
    return when (version) {
        "1.0" -> Hl7Serializer()
        "1.1" -> Hl7Serializerv11()
    }
}
```

All the way up to the completely abstracted way of using annotations and dispatching calls via reflection:
```kotlin
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.functions

annotation class Method(val name: String)
annotation class Version(val version: String)

class HelloService {
    @Version("1.0")
    @Method("SayHello")
    fun sayHello(name: String = "kind stranger") {
        println("Hello $name")
    }

    @Version("2.0")
    @Method("SayHello")
    fun newSayHello(name: String = "kind stranger") {
        println("I am the version 2. I say hello $name")
    }

    companion object {
        fun dispatch(method: String, version: String, vararg args: Any?) {
            val c = HelloService::class
            val ic = c.createInstance()
            c.functions.firstOrNull {
                val methodAnnotation = it.findAnnotation<Method>()
                val versionAnnotation = it.findAnnotation<Version>()
                methodAnnotation?.name == method && versionAnnotation?.version == version
            }?.call(ic, *args) ?: error("Cannot find matching function to call: $method/$version")
        }
    }
}

fun <T : Any> callHello(method: String, version: String, serviceClass: KClass<T>, vararg args: Any?) {
    val ic = serviceClass.createInstance()
    serviceClass.functions.firstOrNull {
        val methodAnnotation = it.findAnnotation<Method>()
        val versionAnnotation = it.findAnnotation<Version>()
        methodAnnotation?.name == method && versionAnnotation?.version == version
    }?.call(ic, *args) ?: error("Cannot find matching function to call: $method/$version")
}

fun main() {
    val helloService = HelloService()
    helloService.sayHello()

    // two different ways to dispatch:
    // callHello is a function that gets passed the class to invoke on
    val c = HelloService::class
    callHello("SayHello", "1.0", c, "not so kind stranger")
    callHello("SayHello", "2.0", c, "kind stranger indeed")

    // dispatch lives in the companion object for the HelloService
    // and takes fewer parameters, but is less generic
    //                    method      version    params
    HelloService.dispatch("SayHello", "1.0", "dispatch stranger")
}
```

The obvious downside of the last example is that it utilizes reflection and is the 
least safe version to invoke. We lose type safety because everything is passed via `vararg` 
is cast to `Any?` when called. This could potentially introduce errors that are harder to diagnose.

## Notes on Testing
No matter what way we start to address this issue, we should consider adding a testing step
that serializers a `Report` object into different formats and then compares that output to a previously
serialized version and then flags a warning if they do not match. This is similar to what we do
with our documentation generation on build. The key difference is needing a method to mark an expected
change vs an unexpected change and then updating the comparison implementation. This would give us
an early warning if some change to a serializer had downstream effects.

## Final Thoughts
The reality is that this is not the only way to approach this issue, and there might be 
better ways to mitigate concerns. For example, we could add serialization methods 
to the translation configuration, and then inject them into the serializer, so a serializer has 
a default version of a method, but can be fed a new way to do things similar to how we do 
mappers now. We could also decorate methods with annotations for specific receivers and 
invoke those that way.

I am posting this proposal to get us start discussing the potential for minimizing downstream 
impacts when we make changes to serializers.

## References