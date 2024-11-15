package com.github.gunin_igor75.daggertask.api

import com.github.gunin_igor75.core.api.NetworkApi
import com.github.gunin_igor75.daggertask.di.AppComponent
import com.github.gunin_igor75.home.di.HomeDependenciesProvider

interface AppDependenciesProvider :
    HomeDependenciesProvider {

    val appComponent: AppComponent

    override fun getNetWorkApi(): NetworkApi {
        return appComponent.getNetworkApi()
    }
}

