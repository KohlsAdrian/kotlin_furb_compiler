package compiler

class SemanticError : AnalysisError {
    constructor(msg: String?, position: Int) : super(msg, position)
    constructor(msg: String?) : super(msg)
}