package com.martin.boot.sample

import android.app.Application
import com.martin.boot.Boot

class BootSampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Boot.init(this)
    }
}