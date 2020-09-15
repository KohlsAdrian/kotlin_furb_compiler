package compiler

import compiler.AnalysisError

class LexicalError : AnalysisError {
    constructor(msg: String?, position: Int) : super(msg, position) {}
    constructor(msg: String?) : super(msg) {}
}