package compiler

class SyntaticError : AnalysisError {
    constructor(msg: String?, position: Int) : super(msg, position)
    constructor(msg: String?) : super(msg)
}