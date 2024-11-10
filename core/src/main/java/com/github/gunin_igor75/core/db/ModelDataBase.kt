package com.github.gunin_igor75.core.db

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.RoomDatabase

@Database(
    entities = [
        Model::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ModelDataBase : RoomDatabase() {

    abstract fun getModelDao(): ModelDap

}

@Dao
interface ModelDap{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addModel(model: Model)
}
