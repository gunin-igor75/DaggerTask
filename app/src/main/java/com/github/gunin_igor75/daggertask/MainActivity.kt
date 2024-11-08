package com.github.gunin_igor75.daggertask

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.gunin_igor75.home.presentation.HomeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appComponent = (applicationContext as AppTaskDagger).appComponent
        appComponent.injectMainActivity(this)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, HomeActivity::class.java))
    }
}