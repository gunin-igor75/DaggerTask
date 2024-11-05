package com.github.gunin_igor75.daggertask.example

import android.content.Context
import android.util.Log
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject
import javax.inject.Named

private const val TAG = "Dagger"

class Analytics @Inject constructor(){
    fun showInfo() {
        Log.d(TAG, "Analytics dagger")
    }
}

interface KeyBoard

class KeyBoardLogitech @Inject constructor(): KeyBoard{
    override fun toString(): String {
        return "Logitech keyBoard"
    }
}

class KeyBoardA4Tech @Inject constructor(): KeyBoard{
    override fun toString(): String {
        return "A4Tech keyBoard"
    }
}

interface Mouse

class MouseLogitech @Inject constructor() : Mouse{
    override fun toString(): String {
        return "logitech mouse"
    }
}

class MouseATech @Inject constructor() : Mouse{
    override fun toString(): String {
        return "A4Tech mouse"
    }
}


class RAM @Inject constructor(){
    override fun toString(): String {
        return "RAM : 16 GB"
    }
}

class Processor @Inject constructor(){
    override fun toString(): String {
        return "Intel core i7 1300K"
    }
}

class MotherBoard @Inject constructor(){
    override fun toString(): String {
        return "Asus Intel 960"
    }
}

data class Computer @AssistedInject constructor(
    @Assisted("id") private val id: Int,
    private val ram: RAM,
    private val processor: Processor,
    private val motherBoard: MotherBoard,
    @Named ("Logitech keyBoard")
    private val keyBoard: KeyBoard,
    private val mouse: Mouse
){

    @AssistedFactory
    interface Factory{
        fun create(
            @Assisted("id") id: Int
        ): Computer
    }

}

class MousePad @Inject constructor(){
    override fun toString(): String {
        return "MousePad"
    }
}

class ResourceComputer @Inject constructor(
    private val context: Context
)