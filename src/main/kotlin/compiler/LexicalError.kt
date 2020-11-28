package compiler

class LexicalError : AnalysisError {
    constructor(msg: String?, position: Int) : super(msg, position)
    constructor(msg: String?) : super(msg)
}