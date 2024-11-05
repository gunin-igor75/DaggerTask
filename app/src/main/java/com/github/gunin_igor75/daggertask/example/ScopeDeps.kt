package com.github.gunin_igor75.daggertask.example

import kotlinx.coroutines.CoroutineScope

interface ScopeDeps {
    fun scope(): CoroutineScope
}