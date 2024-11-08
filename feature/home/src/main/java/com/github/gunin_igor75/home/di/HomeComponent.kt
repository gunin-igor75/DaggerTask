package com.github.gunin_igor75.home.di

import android.content.Context
import com.github.gunin_igor75.home.presentation.HomeActivity
import dagger.Component
import javax.inject.Scope

@HomeScreenScope
@Component(dependencies = [HomeDependenciesProvider::class])
interface HomeComponent: HomeDependenciesProvider {

    @Component.Builder
    interface Builder{

        fun homeDependenciesProvider(homeDependenciesProvider: HomeDependenciesProvider): Builder

        fun build(): HomeComponent

    }

    fun injectHomeActivity(homeActivity: HomeActivity)

    companion object {

        private var homeComponent: HomeComponent? = null

        fun init(applicationContext: Context): HomeComponent {
            val deps = (applicationContext as HomeDependenciesProvider)
            homeComponent?.let { return it }
            val instance = DaggerHomeComponent
                .builder()
                .homeDependenciesProvider(deps)
                .build()
            homeComponent = instance
            return instance
        }
    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class HomeScreenScope