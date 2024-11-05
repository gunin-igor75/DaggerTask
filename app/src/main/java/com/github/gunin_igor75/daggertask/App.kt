package com.github.gunin_igor75.daggertask

import android.app.Application
import com.github.gunin_igor75.daggertask.example.AppComponent
import com.github.gunin_igor75.daggertask.example.DaggerAppComponent
import com.github.gunin_igor75.daggertask.example.DispatcherIODeps
import com.github.gunin_igor75.daggertask.example.ScopeDeps
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class App : Application(), DispatcherIODeps {

    private var _appComponent: AppComponent? = null

    internal val appComponent: AppComponent
        get() = checkNotNull(_appComponent) {
            "AppComponent is not initialized"
        }

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.builder()
            .context(this)
            .scopeDeps(ScopeDepsImpl())
            .dispatcherDeps(this)
            .build()
    }

    private inner class ScopeDepsImpl : ScopeDeps {
        override fun scope(): CoroutineScope {
            return CoroutineScope(SupervisorJob())
        }

    }

    override val dispatcher: CoroutineDispatcher
        get() = Dispatchers.IO

}


//val Context.appComponent: AppComponent
//    get() = when (this) {
//        is App -> appComponent
//        else -> (this.applicationContext as? App)?.appComponent ?: throw IllegalStateException(
//            "App is null"
//        )
//    }



