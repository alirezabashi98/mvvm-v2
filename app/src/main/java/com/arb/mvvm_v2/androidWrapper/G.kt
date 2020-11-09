package com.arb.mvvm_v2.androidWrapper

import android.app.Application
import com.arb.mvvm_v2.di.viewModule
import org.koin.android.ext.android.startKoin

class G : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(applicationContext, listOf(viewModule))

    }

}