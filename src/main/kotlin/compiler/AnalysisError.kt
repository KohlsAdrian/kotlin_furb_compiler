package compiler

open class AnalysisError : Exception {
    var position: Int
        private set

    constructor(msg: String?, position: Int) : super(msg) {
        this.position = position
    }

    constructor(msg: String?) : super(msg) {
        position = -1
    }

    override fun toString(): String {
        return super.toString() + ", @ " + position
    }
}