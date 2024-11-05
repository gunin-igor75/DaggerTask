package com.github.gunin_igor75.daggertask.example

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherIODeps {

    val dispatcher: CoroutineDispatcher
}