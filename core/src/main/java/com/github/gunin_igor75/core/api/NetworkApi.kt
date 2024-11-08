package com.github.gunin_igor75.core.api

import com.github.gunin_igor75.core.di.Other
import retrofit2.Retrofit

interface NetworkApi {

    fun retrofit(): Retrofit

    @Other
    fun retrofitOther(): Retrofit
}
