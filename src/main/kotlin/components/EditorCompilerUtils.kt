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

        fun getCompilerError(message: String?, symbol: String?, lexeme: String?): String = when (message) {
            "Caractere n�o esperado" -> "$symbol símbolo inválido"
            "Erro identificando \"!=\"" -> ""
            "Erro identificando Identificador1" -> "identificador1 $symbol inválido ou não finalizado"
            "Erro identificando Constante2" -> "constante2 $lexeme inválida ou não finalizada"
            "Erro identificando Constante3" -> "constante3 $lexeme inválida ou não finalizada"
            "Erro identificando <ignorar>" -> "comentário de bloco inválido ou não finalizado"
            else -> "?"
        }
    }
}