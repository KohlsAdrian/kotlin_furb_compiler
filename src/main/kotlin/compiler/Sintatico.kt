package compiler

import java.util.*

class Sintatico : Constants {
    private val stack: Stack<Any?> = Stack<Any?>()
    private var currentToken: Token? = null
    private var previousToken: Token? = null
    private var scanner: Lexico? = null
    private var semanticAnalyser: Semantico? = null

    @Throws(LexicalError::class, SyntaticError::class, SemanticError::class)
    private fun step(): Boolean {
        if (currentToken == null) {
            var pos = 0
            if (previousToken != null) pos = previousToken!!.position + previousToken!!.lexeme.length
            currentToken = Token(Constants.DOLLAR, "$", pos)
        }
        val x = (stack.pop() as Int).toInt()
        val a = currentToken!!.id
        return if (x == Constants.EPSILON) {
            false
        } else if (isTerminal(x)) {
            if (x == a) {
                if (stack.empty()) true else {
                    previousToken = currentToken
                    currentToken = scanner!!.nextToken()
                    false
                }
            } else {
                throw SyntaticError(ParserConstants.PARSER_ERROR[x], currentToken!!.position)
            }
        } else if (isNonTerminal(x)) {
            if (pushProduction(x, a)) false else throw SyntaticError(
                ParserConstants.PARSER_ERROR[x],
                currentToken!!.position
            )
        } else {
            // isSemanticAction(x)
            semanticAnalyser!!.executeAction(x - ParserConstants.FIRST_SEMANTIC_ACTION, previousToken)
            false
        }
    }

    private fun pushProduction(topStack: Int, tokenInput: Int): Boolean {
        val p: Int = ParserConstants.PARSER_TABLE[topStack - ParserConstants.FIRST_NON_TERMINAL][tokenInput - 1]
        return if (p >= 0) {
            val production: IntArray = ParserConstants.PRODUCTIONS[p]
            //empilha a produ��o em ordem reversa
            for (i in production.indices.reversed()) {
                stack.push(production[i] as Any?)
            }
            true
        } else false
    }

    @Throws(LexicalError::class, SyntaticError::class, SemanticError::class)
    fun parse(scanner: Lexico, semanticAnalyser: Semantico?) {
        this.scanner = scanner
        this.semanticAnalyser = semanticAnalyser
        stack.clear()
        stack.push(Constants.DOLLAR)
        stack.push(ParserConstants.START_SYMBOL)
        currentToken = scanner.nextToken()
        while (!step());
    }

    companion object {
        private fun isTerminal(x: Int): Boolean {
            return x < ParserConstants.FIRST_NON_TERMINAL
        }

        private fun isNonTerminal(x: Int): Boolean {
            return x >= ParserConstants.FIRST_NON_TERMINAL && x < ParserConstants.FIRST_SEMANTIC_ACTION
        }

        private fun isSemanticAction(x: Int): Boolean {
            return x >= ParserConstants.FIRST_SEMANTIC_ACTION
        }
    }
}