package com.github.gunin_igor75.daggertask

import android.app.Application
import com.github.gunin_igor75.daggertask.example.AppComponent
import com.github.gunin_igor75.daggertask.example.DaggerAppComponent

class App : Application() {

    private var _appComponent: AppComponent? = null

    internal val appComponent: AppComponent
        get() = checkNotNull(_appComponent) {
            "AppComponent is not initialized"
        }

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()
    }
}


//val Context.appComponent: AppComponent
//    get() = when (this) {
//        is App -> appComponent
//        else -> (this.applicationContext as? App)?.appComponent ?: throw IllegalStateException(
//            "App is null"
//        )
//    }



