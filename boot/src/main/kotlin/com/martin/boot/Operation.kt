package com.martin.boot

class Operation internal constructor(val mark: String, var executed: Boolean) {
    companion object {
        internal fun fromMark(mark: String): Operation {
            val executed = Boot.isExecuted(mark)
            return Operation(mark, executed)
        }
    }

    override fun toString(): String {
        return "Operation( mark = $mark, executed = $executed)"
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Operation)
            mark == other.mark
        else false
    }

    override fun hashCode(): Int {
        var result = mark.hashCode()
        result = 31 * result + executed.hashCode()
        return result
    }
}