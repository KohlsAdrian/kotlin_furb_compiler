package compiler

class Lexico @JvmOverloads constructor(input: String? = "") : Constants {
    private var position = 0
    private var input: String? = null
    fun setInput(input: String?) {
        this.input = input
        setPosition(0)
    }

    fun setPosition(pos: Int) {
        position = pos
    }

    @Throws(LexicalError::class)
    fun nextToken(): Token? {
        if (!hasInput()) return null
        val start = position
        var state = 0
        var lastState = 0
        var endState = -1
        var end = -1
        while (hasInput()) {
            lastState = state
            state = nextState(nextChar(), state)
            if (state < 0) break else {
                if (tokenForState(state) >= 0) {
                    endState = state
                    end = position
                }
            }
        }
        if (endState < 0 || endState != state && tokenForState(lastState) == -2) throw LexicalError(
            ScannerConstants.SCANNER_ERROR[lastState], start
        )
        position = end
        var token = tokenForState(endState)
        return if (token == 0) nextToken() else {
            val lexeme = input!!.substring(start, end)
            token = lookupToken(token, lexeme)
            Token(token, lexeme, start)
        }
    }

    private fun nextState(c: Char, state: Int): Int {
        var start: Int = ScannerConstants.SCANNER_TABLE_INDEXES[state]
        var end: Int = ScannerConstants.SCANNER_TABLE_INDEXES[state + 1] - 1
        while (start <= end) {
            val half = (start + end) / 2
            when {
                ScannerConstants.SCANNER_TABLE[half]
                        [0] == c.toInt() -> return ScannerConstants.SCANNER_TABLE[half][1]
                ScannerConstants.SCANNER_TABLE[half][0] < c.toInt() -> start =
                    half + 1
                else -> end = half - 1 //(SCANNER_TABLE[half][0] > c)

            }
        }
        return -1
    }

    private fun tokenForState(state: Int): Int {
        return if (state < 0 || state >= ScannerConstants.TOKEN_STATE.size) -1 else ScannerConstants.TOKEN_STATE[state]
    }

    private fun lookupToken(base: Int, key: String?): Int {
        var start: Int = ScannerConstants.SPECIAL_CASES_INDEXES[base]
        var end: Int = ScannerConstants.SPECIAL_CASES_INDEXES[base + 1] - 1
        while (start <= end) {
            val half = (start + end) / 2
            val comp: Int = ScannerConstants.SPECIAL_CASES_KEYS[half].compareTo(key!!)
            when {
                comp == 0 -> return ScannerConstants.SPECIAL_CASES_VALUES[half]
                comp < 0 -> start = half + 1
                else -> end = half - 1  //(comp > 0)

            }
        }
        return base
    }

    private fun hasInput(): Boolean {
        return position < input!!.length
    }

    private fun nextChar(): Char {
        return if (hasInput()) input!![position++] else (-1).toChar()
    }

    init {
        setInput(input)
    }
}