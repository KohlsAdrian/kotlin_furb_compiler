package compiler

interface ParserConstants {
    companion object {
        const val START_SYMBOL = 40
        const val FIRST_NON_TERMINAL = 40
        const val FIRST_SEMANTIC_ACTION = 68
        val PARSER_TABLE = arrayOf(
            intArrayOf(
                -1,
                0,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                0,
                -1,
                -1,
                0,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                0,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                1,
                -1,
                -1,
                1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                2,
                3,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                3,
                2,
                2,
                3,
                2,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                3,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                4,
                5,
                6,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                16,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                13,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                15,
                14,
                -1,
                14,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                7,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                9,
                10,
                -1,
                8,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                12,
                -1,
                11,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                17,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                18,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                20,
                -1,
                -1,
                21,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                19,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                22,
                23,
                24
            ),
            intArrayOf(
                -1,
                25,
                25,
                25,
                25,
                -1,
                -1,
                25,
                -1,
                -1,
                -1,
                -1,
                -1,
                25,
                25,
                26,
                27,
                27,
                27,
                -1,
                25,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                25,
                25,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                -1,
                -1,
                -1,
                28,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                29,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                30,
                30,
                30,
                30,
                -1,
                -1,
                30,
                -1,
                -1,
                -1,
                -1,
                -1,
                30,
                30,
                -1,
                -1,
                -1,
                -1,
                -1,
                30,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                30,
                30,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                31,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                32,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                33,
                33,
                33,
                33,
                -1,
                -1,
                33,
                -1,
                -1,
                -1,
                -1,
                -1,
                33,
                33,
                -1,
                -1,
                -1,
                -1,
                -1,
                33,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                33,
                33,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                34,
                34,
                -1,
                -1,
                -1,
                35,
                36,
                -1,
                34,
                34,
                34,
                34,
                34,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                34,
                -1,
                34,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                34,
                34,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                37,
                37,
                37,
                37,
                -1,
                -1,
                40,
                -1,
                -1,
                -1,
                -1,
                -1,
                39,
                38,
                -1,
                -1,
                -1,
                -1,
                -1,
                37,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                37,
                37,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                41,
                41,
                41,
                41,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                41,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                41,
                41,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                42,
                42,
                -1,
                -1,
                -1,
                42,
                42,
                -1,
                42,
                42,
                42,
                42,
                42,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                42,
                -1,
                42,
                43,
                43,
                43,
                43,
                43,
                43,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                42,
                42,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                44,
                45,
                46,
                47,
                48,
                49,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                50,
                50,
                50,
                50,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                50,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                50,
                50,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                51,
                51,
                -1,
                -1,
                -1,
                51,
                51,
                -1,
                51,
                51,
                51,
                51,
                51,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                51,
                -1,
                51,
                51,
                51,
                51,
                51,
                51,
                51,
                52,
                53,
                -1,
                -1,
                -1,
                -1,
                51,
                51,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                54,
                54,
                54,
                54,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                54,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                54,
                54,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                55,
                55,
                -1,
                -1,
                -1,
                55,
                55,
                -1,
                55,
                55,
                55,
                55,
                55,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                55,
                -1,
                55,
                55,
                55,
                55,
                55,
                55,
                55,
                55,
                55,
                56,
                57,
                58,
                59,
                55,
                55,
                -1,
                -1,
                -1
            ),
            intArrayOf(
                -1,
                60,
                61,
                62,
                63,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                64,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                65,
                66,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1
            )
        )
        val PRODUCTIONS = arrayOf(
            intArrayOf(83, 41, 84),
            intArrayOf(51, 42),
            intArrayOf(0),
            intArrayOf(41),
            intArrayOf(17),
            intArrayOf(18),
            intArrayOf(19),
            intArrayOf(9, 57, 95, 36, 41, 48, 13, 96),
            intArrayOf(0),
            intArrayOf(45, 49),
            intArrayOf(44),
            intArrayOf(0),
            intArrayOf(44),
            intArrayOf(97, 10, 57, 98, 36, 41, 46),
            intArrayOf(0),
            intArrayOf(45),
            intArrayOf(99, 11, 36, 41),
            intArrayOf(100, 12, 57, 101, 36, 41, 13, 102),
            intArrayOf(2, 90, 52),
            intArrayOf(20, 21, 55, 22),
            intArrayOf(47),
            intArrayOf(50),
            intArrayOf(37, 53),
            intArrayOf(38, 91, 57, 104),
            intArrayOf(39, 91, 57, 104),
            intArrayOf(57, 92),
            intArrayOf(93, 16, 21, 54, 22, 94),
            intArrayOf(43, 93, 21, 16, 21, 54, 22, 22, 94),
            intArrayOf(5, 89, 82),
            intArrayOf(0),
            intArrayOf(57, 82, 56),
            intArrayOf(0),
            intArrayOf(35, 55),
            intArrayOf(59, 58),
            intArrayOf(0),
            intArrayOf(6, 59, 85, 58),
            intArrayOf(7, 59, 86, 58),
            intArrayOf(60),
            intArrayOf(15, 79),
            intArrayOf(14, 80),
            intArrayOf(8, 59, 81),
            intArrayOf(63, 61),
            intArrayOf(0),
            intArrayOf(62, 77, 63, 78),
            intArrayOf(23),
            intArrayOf(24),
            intArrayOf(25),
            intArrayOf(26),
            intArrayOf(27),
            intArrayOf(28),
            intArrayOf(65, 64),
            intArrayOf(0),
            intArrayOf(29, 65, 69, 64),
            intArrayOf(30, 65, 70, 64),
            intArrayOf(67, 66),
            intArrayOf(0),
            intArrayOf(31, 67, 71, 66),
            intArrayOf(32, 67, 72, 66),
            intArrayOf(33, 67, 87, 66),
            intArrayOf(34, 67, 88, 66),
            intArrayOf(2, 103),
            intArrayOf(3, 73),
            intArrayOf(4, 74),
            intArrayOf(5, 89),
            intArrayOf(21, 57, 22),
            intArrayOf(29, 67, 75),
            intArrayOf(30, 67, 76)
        )
        val PARSER_ERROR = arrayOf(
            "",
            "Era esperado fim de programa",
            "Era esperado Identificador1",
            "Era esperado Constante1",
            "Era esperado Constante2",
            "Era esperado Constante3",
            "Era esperado pr_and",
            "Era esperado pr_or",
            "Era esperado pr_not",
            "Era esperado pr_if",
            "Era esperado pr_elif",
            "Era esperado pr_else",
            "Era esperado pr_while",
            "Era esperado pr_end",
            "Era esperado pr_false",
            "Era esperado pr_true",
            "Era esperado pr_input",
            "Era esperado pr_int",
            "Era esperado pr_float",
            "Era esperado pr_str",
            "Era esperado pr_print",
            "Era esperado \"(\"",
            "Era esperado \")\"",
            "Era esperado \"==\"",
            "Era esperado \"!=\"",
            "Era esperado \"<\"",
            "Era esperado \"<=\"",
            "Era esperado \">\"",
            "Era esperado \">=\"",
            "Era esperado \"+\"",
            "Era esperado \"-\"",
            "Era esperado \"*\"",
            "Era esperado \"/\"",
            "Era esperado \"//\"",
            "Era esperado \"%\"",
            "Era esperado \",\"",
            "Era esperado \":\"",
            "Era esperado \"=\"",
            "Era esperado \"+=\"",
            "Era esperado \"-=\"",
            "<programa> inv�lido",
            "<lista_comandos> inv�lido",
            "<lista_comandos1> inv�lido",
            "<tipo> inv�lido",
            "<condicao_else> inv�lido",
            "<condicao_elif> inv�lido",
            "<condicao_elif1> inv�lido",
            "<condicao_if> inv�lido",
            "<condicao_if1> inv�lido",
            "<condicao_if2> inv�lido",
            "<condicao_repeticao> inv�lido",
            "<comando> inv�lido",
            "<comando1> inv�lido",
            "<comando2> inv�lido",
            "<constante_opcional> inv�lido",
            "<lista_expressao> inv�lido",
            "<lista_expressao1> inv�lido",
            "<expressao> inv�lido",
            "<expressao1> inv�lido",
            "<elemento> inv�lido",
            "<relacional> inv�lido",
            "<relacional1> inv�lido",
            "<operador_relacional> inv�lido",
            "<aritmetica> inv�lido",
            "<aritmetica1> inv�lido",
            "<termo> inv�lido",
            "<termo1> inv�lido",
            "<fator> inv�lido"
        )
    }
}