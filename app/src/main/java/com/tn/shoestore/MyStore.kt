package com.tn.shoestore

import android.app.Application
import timber.log.Timber

class MyStore : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}