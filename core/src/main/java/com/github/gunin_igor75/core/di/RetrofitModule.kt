package com.github.gunin_igor75.core.di

import com.github.gunin_igor75.core.utils.Constants.BASE_URL_SERVER_FIRST
import com.github.gunin_igor75.core.utils.Constants.BASE_URL_SERVER_SECOND
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
internal class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofitFirst(): Retrofit {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_SERVER_FIRST)
            .build()
    }

    @Provides
    @Singleton
    @Other
    fun provideRetrofitSecond(): Retrofit {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_SERVER_SECOND)
            .build()
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Other

