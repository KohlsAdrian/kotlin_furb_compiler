package compiler

import compiler.AnalysisError

class SyntaticError : AnalysisError {
    constructor(msg: String?, position: Int) : super(msg, position)
    constructor(msg: String?) : super(msg)
}