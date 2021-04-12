package com.martin.boot

fun runOnce(mark: String, block: () -> Unit): BootBuilder {
    val operation = Operation.fromMark(mark)
    return BootBuilder.withMark(mark).execute(operation, block)
}