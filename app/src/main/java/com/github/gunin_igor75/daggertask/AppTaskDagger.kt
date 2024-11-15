package com.github.gunin_igor75.daggertask

import android.app.Application
import com.github.gunin_igor75.daggertask.api.AppDependenciesProvider
import com.github.gunin_igor75.daggertask.di.AppComponent

class AppTaskDagger: Application(), AppDependenciesProvider {

    override val appComponent: AppComponent = AppComponent.init(this)

}
