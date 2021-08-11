package gov.cdc.prime.router.utils

import gov.cdc.prime.router.Translator
import gov.cdc.prime.router.azure.ReportFunction
import gov.cdc.prime.router.azure.WorkflowEngine
import io.micrometer.core.instrument.Clock
import io.micrometer.core.instrument.Tags
import io.micrometer.core.instrument.composite.CompositeMeterRegistry
import io.micrometer.core.instrument.logging.LoggingMeterRegistry
import io.micrometer.elastic.ElasticConfig
import io.micrometer.elastic.ElasticMeterRegistry

/**
 * Setup the metrics collection engine. Metrics are logged when running in DEV mode.  You need to call the SetupMetrics
 * at the start of your code to initialize the engine.  Use the metrics measurements provided by the Metrics class.
 * @see CompositeMeterRegistry for more infomation.
 */
object PerfMetrics : CompositeMeterRegistry() {
    /**
     * Predefined tags for event types.
     */
    enum class EventType(val tags: Tags) {
        RECEIVE(Tags.of("event", "receive")),
        BATCH(Tags.of("event", "batch")),
        SEND(Tags.of("event", "send"))
    }

    /**
     * Timer names
     */
    enum class TIMERS(val timerName: String) {
        // Report timers
        REPORT_TOTAL("t${ReportFunction::class.java.name}.report.total"),
        REPORT_VALIDATE("t${ReportFunction::class.java.name}.report.validateReport"),
        REPORT_ROUTING("t${ReportFunction::class.java.name}.report.routingReport"),
        REPORT_RECORD("t${ReportFunction::class.java.name}.report.recordReport"),
        REPORT_FINALIZE("t${ReportFunction::class.java.name}.report.finalize"),
        WATERS_TOTAL("t${ReportFunction::class.java.name}.waters.total"),

        // Workflow Engine timers
        WORKFLOW_DISPATCH_UPLOAD("t${WorkflowEngine::class.java.name}.dispatchReport.uploadBody"),
        WORKFLOW_DISPATCH_INSERT("t${WorkflowEngine::class.java.name}.dispatchReport.insertTask"),

        // Translator timers
        TRANSLATOR_JURIS_FILTER("t${Translator::class.java.name}.translateByReceiver.jurisFilter"),
        TRANSLATOR_QUAL_FILTER("t${Translator::class.java.name}.translateByReceiver.qualityFilter"),
        TRANSLATOR_TRANSLATE("t${Translator::class.java.name}.translateByReceiver.translate")
    }

    /**
     * Counter names
     */
    enum class COUNTERS(val counterName: String) {
        REPORT_CONNECTIONS("c${ReportFunction::class.java.name}.report.connections"),
        REPORT_INGESTED("c${ReportFunction::class.java.name}.report.ingested"),
        REPORT_ERRORS("c${ReportFunction::class.java.name}.report.errors"),
        WATERS_CONNECTIONS("c${ReportFunction::class.java.name}.waters.connections")
    }

    init {
        // Log the measurements when running locally
        val primeEnv = System.getenv("PRIME_ENVIRONMENT")
        if (!primeEnv.isNullOrBlank() && "local".equals(primeEnv, true)) {
            setupLogRegistry()
        }

        // Send metrics to an Elastic Search engine when the METRICS_ELASTIC_URL environment variable is defined.
        // E.g. METRICS_ELASTIC_URL=http://host.docker.internal:9200
        if (!System.getenv("METRICS_ELASTIC_URL").isNullOrBlank()) {
            setupElasticRegistry()
        }
    }

    /**
     * Set the meter tags by [type] of event.
     */
    fun setEventType(type: EventType) {
        this.config().commonTags(type.tags)
    }

    /**
     * Output metrics to the log.
     */
    private fun setupLogRegistry() {
        this.add(LoggingMeterRegistry())
    }

    /**
     * Output metrics to an Elastic Search URL defined in the METRICS_ELASTIC_URL environment variable.
     */
    private fun setupElasticRegistry() {
        class CustomElasticConfig : ElasticConfig {
            override fun get(key: String): String? {
                return when (key) {
                    "elastic.host" -> System.getenv("METRICS_ELASTIC_URL")
                        ?: error("METRICS_ELASTIC_URL was not specified")
                    else -> null
                }
            }
        }

        this.add(ElasticMeterRegistry(CustomElasticConfig(), Clock.SYSTEM))
    }
}