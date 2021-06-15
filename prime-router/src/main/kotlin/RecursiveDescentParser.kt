package gov.cdc.prime.router

import kotlin.math.exp

/**
 * The collection of conditions to check in the tree
 */
interface TreeNode<in T> {
    fun <T> apply(): T
}

/**
 * Encapsulates the logic to recursively parse out the different types of filters that we use in ReportStream:
 * - quality filters
 * - jurisdictional filters
 * - mappers
 * - file name templates
 */
object RecursiveDescentParser {
    /**
     * The grammar here is fairly straightforward:
     *
     * symbol: ( | ) | , | " | "
     * identifier: [a-zA-Z0-9_]*
     * value: "identifier" | true | false
     * expression: identifier(expression) | identifier(identifier,identifier) | identifier(identifier,value)
     */
    fun parse(expression: String?): Map<String, String> {
        val root = mutableMapOf<String, String>()
        // if null gets passed in return an empty map
        if (expression == null) {
            return root
        }
        // parse the whole expression
        parseExpression(expression).forEach { (k, v) ->
            root[k] = v
        }

        return root
    }

    private fun parseExpression(expression: String): Map<String, String> {
        var identifier: String = ""
        expression.forEach { token ->
            when (token) {
                '(' -> {
                    val nextExpression = expression.substring(identifier.length)
                    return mapOf(identifier to nextExpression)
                }
                else -> {
                    identifier += token
                }
            }
        }
    }

    private fun parseFactor(expression: String) {

    }

    private fun parseValue(expression: String) {

    }

    private fun parseIdentifier(expression: String) {

    }
}