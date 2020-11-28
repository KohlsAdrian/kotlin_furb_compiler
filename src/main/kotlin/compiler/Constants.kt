package compiler

interface Constants : ScannerConstants, ParserConstants {
    companion object {
        const val EPSILON = 0
        const val DOLLAR = 1

        var t_Identificador1 = 2
        var t_Constante1 = 3
        var t_Constante2 = 4
        var t_Constante3 = 5
        var t_pr_and = 6
        var t_pr_or = 7
        var t_pr_not = 8
        var t_pr_if = 9
        var t_pr_elif = 10
        var t_pr_else = 11
        var t_pr_while = 12
        var t_pr_end = 13
        var t_pr_false = 14
        var t_pr_true = 15
        var t_pr_input = 16
        var t_pr_int = 17
        var t_pr_float = 18
        var t_pr_str = 19
        var t_pr_print = 20
        var t_TOKEN_21 = 21 //"("

        var t_TOKEN_22 = 22 //")"

        var t_TOKEN_23 = 23 //"=="

        var t_TOKEN_24 = 24 //"!="

        var t_TOKEN_25 = 25 //"<"

        var t_TOKEN_26 = 26 //"<="

        var t_TOKEN_27 = 27 //">"

        var t_TOKEN_28 = 28 //">="

        var t_TOKEN_29 = 29 //"+"

        var t_TOKEN_30 = 30 //"-"

        var t_TOKEN_31 = 31 //"*"

        var t_TOKEN_32 = 32 //"/"

        var t_TOKEN_33 = 33 //"//"

        var t_TOKEN_34 = 34 //"%"

        var t_TOKEN_35 = 35 //","

        var t_TOKEN_36 = 36 //":"

        var t_TOKEN_37 = 37 //"="

        var t_TOKEN_38 = 38 //"+="

        var t_TOKEN_39 = 39 //"-="

    }
}