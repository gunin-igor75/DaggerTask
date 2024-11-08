package com.github.gunin_igor75.daggertask.di

import android.content.Context
import com.github.gunin_igor75.core.api.NetworkApi
import com.github.gunin_igor75.daggertask.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@AppScope
@Component(
    modules = [AppModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent

    }

    fun injectMainActivity(mainActivity: MainActivity)

    fun getNetworkApi(): NetworkApi

}


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

