package com.github.gunin_igor75.core.di

import com.github.gunin_igor75.core.api.NetworkApi
import dagger.Component
import javax.inject.Singleton


@Component(modules = [RetrofitModule::class])
@Singleton
interface NetworkComponent: NetworkApi{

    companion object {
        private var networkComponent: NetworkComponent? = null

        fun init(): NetworkComponent {
            networkComponent?.let { return it }
            val instance = DaggerNetworkComponent.create()
            networkComponent = instance
            return instance
        }
    }
}

