package com.github.gunin_igor75.core.di

import android.content.Context
import androidx.room.Room
import com.github.gunin_igor75.core.db.ModelDataBase
import com.github.gunin_igor75.core.utils.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
class RoomModule {

    @Qualifier
    @Singleton
    @Provides
    fun provideRoomDataBase(context: Context): ModelDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = ModelDataBase::class.java,
            name = Constants.DB_NAME
        ).build()
    }
}