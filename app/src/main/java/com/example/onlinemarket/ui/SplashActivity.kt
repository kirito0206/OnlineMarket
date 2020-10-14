package com.example.onlinemarket.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.onlinemarket.databinding.ActivitySplashBinding
import com.example.onlinemarket.viewmodel.SplashViewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding : ActivitySplashBinding
    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashViewModel =
            ViewModelProviders.of(this).get(splashViewModel::class.java)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater,null,false)
        splashBinding.data = splashViewModel
        splashBinding.lifecycleOwner = this
        setContentView(splashBinding.root)
    }
}