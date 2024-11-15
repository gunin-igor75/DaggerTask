package com.github.gunin_igor75.daggertask.di

import com.github.gunin_igor75.core.api.NetworkApi
import com.github.gunin_igor75.core.di.NetworkComponent
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @AppScope
    @Provides
    fun providesNetworkApi(): NetworkApi {
        return NetworkComponent.init()
    }
}