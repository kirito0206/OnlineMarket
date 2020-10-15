package com.example.onlinemarket.viewmodel

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinemarket.R
import com.example.onlinemarket.ui.MainActivity

class SplashViewModel : ViewModel() {

    val splashPic = MutableLiveData<Int>().apply { value = R.drawable.splash_bg }
    val splashText = MutableLiveData<String>().apply { value = "跳过" }

    fun intentToMain(view : View){
        val intent = Intent(view.context,MainActivity::class.java)
        (view.context as Activity).startActivity(intent)
    }
}