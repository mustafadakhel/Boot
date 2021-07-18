package com.martin.boot

internal interface Operations {
    fun isExecuted(mark: String): Boolean
    fun setExecuted(operation: Operation)
    fun execute(operation: Operation, block: () -> Unit)
    fun getAllOperations(): List<Operation>
}