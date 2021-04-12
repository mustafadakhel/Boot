package com.martin.boot

import android.content.Context
import android.content.SharedPreferences

object Boot {
    private lateinit var preference: SharedPreferences

    fun init(context: Context) {
        preference = context.applicationContext.getSharedPreferences("once", Context.MODE_PRIVATE)
    }

    internal fun isExecuted(mark: String): Boolean {
        assertInit()
        return preference.getBoolean(mark, false)
    }

    internal fun setExecuted(operation: Operation) {
        assertInit()
        preference.edit().putBoolean(operation.mark, true).apply()
        operation.executed = true
    }

    internal fun execute(operation: Operation, block: () -> Unit) {
        assertInit()
        if (isExecuted(operation.mark).not())
            runCatching(block).onSuccess {
                setExecuted(operation)
            }
    }

    private fun assertInit() {
        if (::preference.isInitialized.not())
            throw ExceptionsUtils.BootNotInitializedException
    }

    fun getAllOperations(): List<Operation> {
        return preference.all.map {
            val executed = (it.value as? Boolean?) ?: false
            Operation(it.key, executed)
        }
    }
}