package components

private enum class COMPILERID {
    PR,
    EPSILON,
    DOLLAR,
    IDENTIFICADOR,
    CONSTANTE,
    SS,
    NONE,
}

abstract class EditorCompilerUtils {
    companion object {


        fun getClassById(id: Int): String {
            val compilerId = when (id) {
                0 -> COMPILERID.EPSILON
                1 -> COMPILERID.DOLLAR
                2 -> COMPILERID.IDENTIFICADOR
                in 3..5 -> COMPILERID.CONSTANTE
                in 6..23 -> COMPILERID.PR
                in 24..42 -> COMPILERID.SS
                else -> COMPILERID.NONE
            }

            return when (compilerId) {
                COMPILERID.PR -> "Palavra Reservada"
                COMPILERID.EPSILON -> "&"
                COMPILERID.DOLLAR -> "\$"
                COMPILERID.IDENTIFICADOR -> "Identificador"
                COMPILERID.CONSTANTE -> "Constante"
                COMPILERID.SS -> "símbolo especial"
                COMPILERID.NONE -> "?"
            }
        }

        fun getLexicalError(message: String?, symbol: String?, lexeme: String?): String = when (message) {
            "Caractere n�o esperado" -> "$symbol símbolo inválido"
            "Erro identificando \"!=\"" -> "! simbolo inválido"
            "Erro identificando Identificador1" -> "identificador1 $symbol inválido ou não finalizado"
            "Erro identificando Constante2" -> "constante str inválida ou não finalizada"
            "Erro identificando Constante3" -> "constante str inválida ou não finalizada"
            "Erro identificando <ignorar>" -> "comentário de bloco inválido ou não finalizado"
            else -> ""
        }

        fun getSyntaticError(message: String?, symbol: String?): String = when(message) {
            "Era esperado fim de programa" -> "Econtrado EOF esperado \"$symbol\""
            "Era esperado Identificador1" -> "Encontrado \"$symbol\" esperado identificador"
            "Era esperado Constante1" -> "Esperado constante \"$symbol\""
            "Era esperado Constante2" -> "Esperado constante \"$symbol\""
            "Era esperado Constante3" -> "Esperado constante \"$symbol\""
            "Era esperado pr_and" -> "Encontrado \"$symbol\" esperado and"
            "Era esperado pr_or" -> "Encontrado \"$symbol\" esperado or"
            "Era esperado pr_not" -> "Encontrado \"$symbol\" esperado not"
            "Era esperado pr_if" -> "Encontrado \"$symbol\" esperado if"
            "Era esperado pr_elif" -> "Encontrado \"$symbol\" esperado elif"
            "Era esperado pr_else" -> "Encontrado \"$symbol\" esperado else"
            "Era esperado pr_for" -> "Encontrado \"$symbol\" esperado for"
            "Era esperado pr_in" -> "Encontrado \"$symbol\" esperado in"
            "Era esperado pr_range" -> "Encontrado \"$symbol\" esperado range"
            "Era esperado pr_while" -> "Encontrado \"$symbol\" esperado while"
            "Era esperado pr_end" -> "Encontrado \"$symbol\" esperado end"
            "Era esperado pr_false" -> "Encontrado \"$symbol\" esperado false"
            "Era esperado pr_true" -> "Encontrado \"$symbol\" esperado true"
            "Era esperado pr_input" -> "Encontrado \"$symbol\" esperado input"
            "Era esperado pr_int" -> "Encontrado \"$symbol\" esperado int"
            "Era esperado pr_float" -> "Encontrado \"$symbol\" esperado float"
            "Era esperado pr_str" -> "Encontrado \"$symbol\" esperado str"
            "Era esperado pr_print" -> "Encontrado \"$symbol\" esperado print"
            "Era esperado \"(\"" -> "Encontrado \"$symbol\" esperado ("
            "Era esperado \")\"" -> "Encontrado \"$symbol\" esperado )"
            "Era esperado \"==\"" -> "Encontrado \"$symbol\" esperado =="
            "Era esperado \"!=\"" -> "Encontrado \"$symbol\" esperado !="
            "Era esperado \"<\"" -> "Encontrado \"$symbol\" esperado <"
            "Era esperado \"<=\"" -> "Encontrado \"$symbol\" esperado <="
            "Era esperado \">\"" -> "Encontrado \"$symbol\" esperado >"
            "Era esperado \">=\"" -> "Encontrado \"$symbol\" esperado >="
            "Era esperado \"+\"" -> "Encontrado \"$symbol\" esperado +"
            "Era esperado \"-\"" -> "Encontrado \"$symbol\" esperado -"
            "Era esperado \"*\"" -> "Encontrado \"$symbol\" esperado *"
            "Era esperado \"/\"" -> "Encontrado \"$symbol\" esperado /"
            "Era esperado \"//\"" -> "Encontrado \"$symbol\" esperado //"
            "Era esperado \"%\"" -> "Encontrado \"$symbol\" esperado %"
            "Era esperado \",\"" -> "Encontrado \"$symbol\" esperado ,"
            "Era esperado \":\"" -> "Encontrado \"$symbol\" esperado :"
            "Era esperado \"=\"" -> "Encontrado \"$symbol\" esperado ="
            "Era esperado \"+=\"" -> "Encontrado \"$symbol\" esperado +="
            "Era esperado \"-=\"" -> "Encontrado \"$symbol\" esperado -="
            "<lista_comandos> inv�lido" -> "Encontrado \"$symbol\" esperado id, for, if, print, while"
            "<lista_comandos1> inv�lido" -> "Encontrado \"$symbol\" esperado id, for, if, print, while"
            "<tipo> inv�lido" -> "Encontrado \"$symbol\" esperada tipo"
            "<comando> inv�lido" -> "Encontrado \"$symbol\" esperado id, constante, not, tipo, input, (, +, -"
            "<comando1> inv�lido" -> "Encontrado \"$symbol\" esperado id, constante, not, tipo, input, (, +, -"
            "<comando2> inv�lido" -> "Encontrado \"$symbol\" esperado id, constante, not, tipo, input, (, +, -"
            "<lista_expressao> inv�lido" -> "Encontrado \"$symbol\" esperada uma expressão"
            "<lista_expressao1> inv�lido" -> "Encontrado \"$symbol\" esperada uma expressão"
            "<expressao> inv�lido" -> "Encontrado \"$symbol\" esperada uma expressão"
            "<expressao1> inv�lido" -> "Encontrado \"$symbol\" esperada uma expressão"
            "<condicao_else> inv�lido" -> "Encontrado \"$symbol\" esperado else"
            "<condicao_elif> inv�lido" -> "Encontrado \"$symbol\" esperado elif"
            "<condicao_elif1> inv�lido" -> "Encontrado \"$symbol\" esperado elif"
            "<condicao_if> inv�lido" -> "Encontrado \"$symbol\" esperado if"
            "<condicao_if1> inv�lido" -> "Encontrado \"$symbol\" esperado if"
            "<condicao_if2> inv�lido" -> "Encontrado \"$symbol\" esperado if"
            //tabela lexica
            "<condicao_repeticao> inv�lido" -> "Encontrado \"$symbol\" esperado for, while"
            "<condicao_repeticao1> inv�lido" -> "Encontrado \"$symbol\" esperado in"
            "<condicao_repeticao2> inv�lido" -> "Encontrado \"$symbol\" esperado range"
            "<constante_opcional> inv�lido" -> "Encontrado \"$symbol\" esperado \")\", constante"
            // esperado uma expressao
            "<elemento> inv�lido" -> "Encontrado \"$symbol\" esperado uma expressao"
            "<relacional> inv�lido" -> "Encontrado \"$symbol\" esperado uma expressao"
            "<relacional1> inv�lido" -> "Encontrado \"$symbol\" esperado uma expressao"
            "<operador_relacional> inv�lido" -> "Encontrado \"$symbol\" esperado uma expressao"
            "<aritmetica> inv�lido" -> "Encontrado \"$symbol\" esperado uma expressao"
            "<aritmetica1> inv�lido" -> "Encontrado \"$symbol\" esperado uma expressao"
            "<termo> inv�lido" -> "Encontrado \"$symbol\" esperado uma expressao"
            "<termo1> inv�lido" -> "Encontrado \"$symbol\" esperado uma expressao"
            "<fator> inv�lido" -> "Encontrado \"$symbol\" esperado uma expressao"
            else  -> ""
        }
    }
}