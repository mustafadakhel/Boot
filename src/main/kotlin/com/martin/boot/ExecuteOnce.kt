package com.martin.boot

fun executeOnce(mark: String, block: () -> Unit): BootBuilder {
    return BootBuilder.withMark(mark).execute(block)
}