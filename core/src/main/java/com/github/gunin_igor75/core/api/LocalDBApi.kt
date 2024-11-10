package com.github.gunin_igor75.core.api

import com.github.gunin_igor75.core.db.ModelDataBase

interface LocalDBApi {
    fun getLocalDb(): ModelDataBase
}