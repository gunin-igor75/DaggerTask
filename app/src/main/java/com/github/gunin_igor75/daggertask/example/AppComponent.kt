package com.github.gunin_igor75.daggertask.example

import android.content.Context
import com.github.gunin_igor75.daggertask.MainActivity
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Scope


@Component(
    modules = [AppModule::class],
    dependencies = [ScopeDeps::class, DispatcherIODeps::class]
)
@AppScope
interface AppComponent{

    @Component.Builder
    interface Builder{
        fun context(
            @BindsInstance context: Context
        ): Builder

        fun scopeDeps(scopeDeps: ScopeDeps): Builder

        fun dispatcherDeps(dispatcherIODeps: DispatcherIODeps): Builder

        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)

}

@Module(includes = [ComponentsModule::class])
interface AppModule

@Module
interface ComponentsModule{

    @[Binds Logitech]
    fun bindMouseLogitech(mouse: MouseLogitech): Mouse

    // По умолчанию если не указываю в создании объекта
    @Binds
    fun bindMouseA4Tech(mouse: MouseATech): Mouse

    @[Binds Named("Logitech keyBoard")]
    fun bindKeyBoardLogitech(keyBoard: KeyBoardLogitech): KeyBoard

    @[Binds Named("A4Tech keyBoard")]
    fun bindKeyBoardA4Tech(keyBoard: KeyBoardA4Tech): KeyBoard
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Logitech

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class A4Tech

@Scope
annotation class AppScope