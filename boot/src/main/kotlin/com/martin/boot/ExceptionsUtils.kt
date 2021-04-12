package com.martin.boot

object ExceptionsUtils {
    object BootNotInitializedException : Throwable(notInitializedMessage)

    const val notInitializedMessage =
        "Please use Boot.init(context) to initialize Boot before first usage"
}