package com.github.gunin_igor75.daggertask

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.gunin_igor75.daggertask.example.Analytics
import com.github.gunin_igor75.daggertask.example.Computer
import com.github.gunin_igor75.daggertask.example.MousePad
import com.github.gunin_igor75.daggertask.example.ResourceComputer
import dagger.Lazy
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: Computer.Factory

    private val computer: Computer by lazy {
        factory.create(10)
    }

    @Inject
    lateinit var mousePad: Lazy<MousePad>

    @Inject
    lateinit var resourceComputer: ResourceComputer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).appComponent.inject(this)
        Log.d(TAG, computer.toString())
        val mousePadCurrent = mousePad.get()

    }

    @Inject
    fun showAnalytics(analytics: Analytics) {
        analytics.showInfo()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}