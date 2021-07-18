package com.martin.boot

import android.content.Context

object Boot {
	internal lateinit var operator: Operations

	fun init(context: Context) {
		initInternal(context)
	}

	private fun initInternal(context: Context) {
		operator = BootOperator(context)
	}

	fun getAllOperations(): List<Operation> {
		return operator.getAllOperations()
	}

	fun isExecuted(mark: String): Boolean {
		return operator.isExecuted(mark)
	}
}

