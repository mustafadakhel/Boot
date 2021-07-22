package com.martin.boot

@Suppress("unused")
class BootBuilder private constructor(private val operation: Operation) {

    private var alreadyExecuted = false

    init {
        alreadyExecuted = operation.executed
    }

    companion object {
        internal fun withMark(mark: String): BootBuilder {
            return BootBuilder(Operation.fromMark(mark))
        }
    }

    fun isExecuted(): Boolean {
        return alreadyExecuted
    }

    fun setExecuted(): BootBuilder {
        Boot.operator.setExecuted(operation)
        return this
    }

    internal fun execute(block: () -> Unit): BootBuilder {
        Boot.operator.execute(operation, block)
        return this
    }

    fun alreadyExecuted(operation: () -> Unit) {
        if (alreadyExecuted)
            operation()
    }
}

