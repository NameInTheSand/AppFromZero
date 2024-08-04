package com.ukrdroiddev.appfromzero

import android.app.Application
import com.ukrdroiddev.data.modules.datamodule
import com.ukrdroiddev.presentation.module.presentationModule
import org.koin.core.context.GlobalContext.startKoin

class FromZeroApp: Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(datamodule, presentationModule))
        }
    }
}