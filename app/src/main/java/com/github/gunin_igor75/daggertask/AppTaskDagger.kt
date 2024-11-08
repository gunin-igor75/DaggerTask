package com.github.gunin_igor75.daggertask

import android.app.Application
import com.github.gunin_igor75.core.api.NetworkApi
import com.github.gunin_igor75.daggertask.api.AppDependenciesProvider
import com.github.gunin_igor75.daggertask.di.DaggerAppComponent

class AppTaskDagger: Application(), AppDependenciesProvider {

    val appComponent by lazy {
        DaggerAppComponent
            .builder()
            .context(this)
            .build()
    }

    override fun getNetWorkApi(): NetworkApi {
        return appComponent.getNetworkApi()
    }
}
