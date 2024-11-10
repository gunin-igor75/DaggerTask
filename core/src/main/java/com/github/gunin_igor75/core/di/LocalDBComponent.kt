package com.github.gunin_igor75.core.di

import android.content.Context
import com.github.gunin_igor75.core.api.LocalDBApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [RoomModule::class]
)
interface LocalDBComponent : LocalDBApi {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): LocalDBComponent

    }

    companion object {

        private var localDBComponent: LocalDBComponent? = null

        fun init(context: Context): LocalDBComponent {
            localDBComponent?.let { return it }
            val instance = DaggerLocalDBComponent
                .builder()
                .context(context)
                .build()
            localDBComponent = instance
            return instance
        }

    }
}
