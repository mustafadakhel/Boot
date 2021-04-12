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

    fun isExecuted(): BootBuilder {
        alreadyExecuted
        return this
    }

    fun setExecuted(): BootBuilder {
        Boot.setExecuted(operation)
        return this
    }

    internal fun execute(mark: Operation, block: () -> Unit): BootBuilder {
        Boot.execute(mark, block)
        return this
    }

    fun alreadyRun(operation: () -> Unit) {
        if (alreadyExecuted)
            operation()
    }
}

