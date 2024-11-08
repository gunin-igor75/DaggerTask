package com.github.gunin_igor75.home.di

import com.github.gunin_igor75.core.api.NetworkApi

interface HomeDependenciesProvider {

    fun getNetWorkApi(): NetworkApi

}
