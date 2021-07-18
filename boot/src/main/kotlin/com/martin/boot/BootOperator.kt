package com.martin.boot

import android.content.Context
import android.content.SharedPreferences

internal class BootOperator(context: Context) : Operations {
    private var preference: SharedPreferences =
        context.applicationContext.getSharedPreferences("boot.operations", Context.MODE_PRIVATE)


    override fun isExecuted(mark: String): Boolean {
        return preference.getBoolean(mark, false)
    }

    override fun setExecuted(operation: Operation) {
        preference.edit().putBoolean(operation.mark, true).apply()
        operation.executed = true
    }

    override fun execute(operation: Operation, block: () -> Unit) {
        if (isExecuted(operation.mark).not())
            runCatching(block).onSuccess {
                setExecuted(operation)
            }
    }

    override fun getAllOperations(): List<Operation> {
        return preference.all.map {
            val executed = (it.value as? Boolean?) ?: false
            Operation(it.key, executed)
        }
    }

}