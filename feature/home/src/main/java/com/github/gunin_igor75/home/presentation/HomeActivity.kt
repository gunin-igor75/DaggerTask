package com.github.gunin_igor75.home.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.gunin_igor75.core.api.NetworkApi
import com.github.gunin_igor75.home.R
import com.github.gunin_igor75.home.di.HomeComponent
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var networkApi: NetworkApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeComponent.init(applicationContext).injectHomeActivity(this)
        setContentView(R.layout.activity_home)
        val retrofit = networkApi.retrofit()
        val retrofitOther = networkApi.retrofitOther()
        Log.d(TAG, retrofit.toString())
        Log.d(TAG, retrofitOther.toString())
    }

    companion object{
        private const val TAG = "HomeActivity"
    }
}