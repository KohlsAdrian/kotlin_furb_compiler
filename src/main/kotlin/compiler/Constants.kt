package compiler

interface Constants : ScannerConstants {
    companion object {
        const val EPSILON = 0
        const val DOLLAR = 1
        const val t_Identificador1 = 2
        const val t_Constante1 = 3
        const val t_Constante2 = 4
        const val t_Constante3 = 5
        const val t_pr_and = 6
        const val t_pr_or = 7
        const val t_pr_not = 8
        const val t_pr_if = 9
        const val t_pr_elif = 10
        const val t_pr_else = 11
        const val t_pr_for = 12
        const val t_pr_in = 13
        const val t_pr_range = 14
        const val t_pr_while = 15
        const val t_pr_end = 16
        const val t_pr_false = 17
        const val t_pr_true = 18
        const val t_pr_input = 19
        const val t_pr_int = 20
        const val t_pr_float = 21
        const val t_pr_str = 22
        const val t_pr_print = 23
        const val t_TOKEN_24 = 24 //"("
        const val t_TOKEN_25 = 25 //")"
        const val t_TOKEN_26 = 26 //"=="
        const val t_TOKEN_27 = 27 //"!="
        const val t_TOKEN_28 = 28 //"<"
        const val t_TOKEN_29 = 29 //"<="
        const val t_TOKEN_30 = 30 //">"
        const val t_TOKEN_31 = 31 //">="
        const val t_TOKEN_32 = 32 //"+"
        const val t_TOKEN_33 = 33 //"-"
        const val t_TOKEN_34 = 34 //"*"
        const val t_TOKEN_35 = 35 //"/"
        const val t_TOKEN_36 = 36 //"//"
        const val t_TOKEN_37 = 37 //"%"
        const val t_TOKEN_38 = 38 //","
        const val t_TOKEN_39 = 39 //":"
        const val t_TOKEN_40 = 40 //"="
        const val t_TOKEN_41 = 41 //"+="
        const val t_TOKEN_42 = 42 //"-="
    }
}