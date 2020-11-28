package compiler

import components.CustomSemantico
import java.util.*

class Semantico : Constants {
    private var customSemantico: CustomSemantico

    private var op = ""
    private var code = ""

    fun getCompiled() = this.code
    fun getCode() = this.op


    init {
        var id: String? = ""
        var currentOperator: String? = ""
        val stackTypes: Stack<String> = Stack()
        customSemantico = CustomSemantico(code, id, currentOperator, stackTypes)
    }

    @Throws(SemanticError::class)
    fun executeAction(action: Int, token: Token?) {
        //println("A��o #$action, Token: $token")
        customSemantico.action(action, token)
    }

}