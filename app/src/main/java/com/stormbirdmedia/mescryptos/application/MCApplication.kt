package com.stormbirdmedia.mescryptos.application

import android.app.Application
import com.stormbirdmedia.di.dataModule
import com.stormbirdmedia.domain.di.domainModule
import com.stormbirdmedia.mescryptos.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree


class MCApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Android context
            androidContext(this@MCApplication)
            // modules
            modules(
                networkModule,
                dataModule,
                domainModule,
                presenterModule)
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

}