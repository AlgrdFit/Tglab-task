package com.tgLab.tglab_androidtask

import android.app.Application
import com.tgLab.tglab_androidtask.di.nbaModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NBAApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@NBAApplication)
            modules(nbaModule)
        }
    }
}