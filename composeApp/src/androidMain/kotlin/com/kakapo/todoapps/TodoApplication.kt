package com.kakapo.todoapps

import android.app.Application
import di.appModule
import org.koin.core.context.startKoin

class TodoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule())
        }
    }
}