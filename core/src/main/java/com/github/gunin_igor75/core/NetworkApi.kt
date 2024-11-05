package com.github.gunin_igor75.core

import retrofit2.Retrofit

interface NetworkApi {
    fun getRetrofit(): Retrofit
}