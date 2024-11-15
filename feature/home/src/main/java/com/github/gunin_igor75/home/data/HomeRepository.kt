package com.github.gunin_igor75.home.data

import com.github.gunin_igor75.core.api.NetworkApi
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val networkApi: NetworkApi
) {
    fun getInfoServerFirst() = networkApi.retrofit()

    fun getInfoServerSecond() = networkApi.retrofitOther()
}