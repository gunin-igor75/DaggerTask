package com.github.gunin_igor75.core.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "models")
data class Model(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String
)
