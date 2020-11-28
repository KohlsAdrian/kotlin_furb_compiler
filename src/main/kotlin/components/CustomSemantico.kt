package components

import compiler.SemanticError
import compiler.Token
import java.util.*

class CustomSemantico(var code: String, var id: String?, var currentOperator: String?, var stackTypes: Stack<String>) {


    fun action(action: Int, token: Token?){
        val success = when (action) {
            1 -> action01()
            2 -> action02()
            3 -> action03()
            4 -> action04()
            5 -> action05(token)
            6 -> action06(token)
            7 -> action07()
            8 -> action08()
            9 -> action09(token)
            10 -> action10()
            11 -> action11()
            12 -> action12()
            13 -> action13()
            14 -> action14()
            15 -> action15()
            16 -> action16()
            17 -> action17()
            18 -> action18()
            19 -> action19()
            20 -> action20()
            21 -> action21()
            22 -> action22(token)
            else -> false
        }

        if(!success) {
            val message = if (action in 1..4 || action in 7..8) "tipos incompatíveis em expressão aritmética"
            else if (action == 10) "tipos incompatíveis em expressão relacional"
            else if (action == 13) "tipo incompatível em expressão lógica"
            else if (action in 17..18) "tipos incompatíveis em expressão lógica"
            else if(action == 19) "\"//\" – quociente da divisão entre valores do tipo int"
            else if(action == 20) "\"%\" – resto da divisão entre valores do tipo int"
            else if(action == 21) "Ação semântica não implementada: $action"
            else ""
            throw SemanticError(message)
        }
    }


    private fun action01(): Boolean {
        val type1 = stackTypes.pop()
        val type2 = stackTypes.pop()
        if ((type1 != "float64" && type1 != "int64") || (type2 != "float64" && type2 != "int64"))
            return false
        else {
            if (type1 == "float64" || type2 == "float64")
                stackTypes.push("float64")
            else stackTypes.push("int64")
            code = code.plus("add\n")
        }
        return true
    }

    private fun action02(): Boolean {
        val type1 = stackTypes.pop()
        val type2 = stackTypes.pop()
        if (type1 == "float64" || type2 == "float64")
            stackTypes.add("float64")
        else stackTypes.add("int64")
        code = code.plus("sub\n")
        return true
    }

    private fun action03(): Boolean {
        val type1 = stackTypes.pop()
        val type2 = stackTypes.pop()
        if (type1 == "float64" || type2 == "float64")
            stackTypes.add("float64")
        else stackTypes.add("int64")
        code = code.plus("mul\n")
        return true
    }

    private fun action04(): Boolean {
        val type1 = stackTypes.pop()
        val type2 = stackTypes.pop()
        if (type1 == type2) stackTypes.add(type1)
        else return false
        code = code.plus("div\n")
        return true
    }

    private fun action05(token: Token?): Boolean {
        stackTypes.add("int64")
        code = code.plus("ldc.i8 ${token?.lexeme}\n")
        code = code.plus("conv.r8\n")
        return true
    }

    private fun action06(token: Token?): Boolean {
        stackTypes.add("float64")
        code = code.plus("ldc.r8 ${token?.lexeme}\n")
        return true
    }

    private fun action07(): Boolean {
        val type = stackTypes.pop()
        if(type == "float64" || type == "int64")
            stackTypes.push(type)
        else return false
        return true
    }

    private fun action08(): Boolean {
        val type = stackTypes.pop()
        if(type == "float64" || type == "int64")
            stackTypes.push(type)
        else return false
        code = code.plus("ldc.i8 -1\n")
        code = code.plus("conv.r8\n")
        code = code.plus("mul\n")
        return true
    }

    private fun action09(token: Token?): Boolean {
        currentOperator  = token?.lexeme
        return true
    }

    private fun action10(): Boolean {
        val type1 = stackTypes.pop()
        val type2 = stackTypes.pop()
        if(type1 == type2)
            stackTypes.push("bool")
        else return false
        when(currentOperator){
            ">" -> code =  code.plus("cgt")
            "<" -> code =  code.plus("clt")
            "==" -> code =  code.plus("ceq")
        }
        return true
    }
    private fun action11(): Boolean {
        stackTypes.push("bool")
        code = code.plus("ldc.i4.1\n")
        return true
    }
    private fun action12(): Boolean {
        stackTypes.push("bool")
        code = code.plus("ldc.i4.0\n")
        return true
    }

    private fun action13(): Boolean {
        val type = stackTypes.pop()
        if(type == "bool")
            stackTypes.push("bool")
        else return false
        code = code.plus("ldc.i4.1\n")
        code = code.plus("xor\n")
        return true
    }

    private fun action14(): Boolean {
        val type = stackTypes.pop()
        if (type == "int64")
            code = code.plus("conv.i8\n")
        val void = "call void [mscorlib]System.Console::Write($type)\n"
        code = code.plus(void)
        return true
    }

    private fun action15(): Boolean {
        code = code.plus(".assembly extern mscorlib {}\n")
        code = code.plus(".assembly _codigo_objeto{}\n")
        code = code.plus(".module   _codigo_objeto.exe\n")
        code = code.plus("\n")
        code = code.plus(".class public _UNICA{\n")
        code = code.plus(".method static public void _principal() {\n")
        code = code.plus(".entrypoint\n")
        return true
    }

    private fun action16(): Boolean {
        code = code.plus("ret\n}\n}\n")
        return true
    }

    private fun action17(): Boolean {

        return true
    }

    private fun action18(): Boolean {

        return true
    }
    private fun action19(): Boolean {

        return true
    }
    private fun action20(): Boolean {

        return true
    }
    private fun action21(): Boolean {

        return true
    }
    private fun action22(token: Token?): Boolean {
        id  = token?.lexeme
        return true
    }

    private fun action23(): Boolean {

        return true
    }

    private fun action24(): Boolean {

        return true
    }

    private fun action25(): Boolean {

        return true
    }

    private fun action26(): Boolean {

        return true
    }

    private fun action27(): Boolean {

        return true
    }

    private fun action28(): Boolean {

        return true
    }

    private fun action29(): Boolean {

        return true
    }

    private fun action30(): Boolean {

        return true
    }

    private fun action31(): Boolean {

        return true
    }

    private fun action32(): Boolean {

        return true
    }

    private fun action33(): Boolean {

        return true
    }

    private fun action34(): Boolean {

        return true
    }

    private fun action35(): Boolean {

        return true
    }

    private fun action36(): Boolean {

        return true
    }

}