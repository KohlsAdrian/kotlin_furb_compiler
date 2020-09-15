package compiler

class Token(val id: Int, val lexeme: String, val position: Int) {
    override fun toString(): String {
        return "$id ( $lexeme ) @ $position"
    }
}