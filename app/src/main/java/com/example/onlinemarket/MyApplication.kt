package com.example.onlinemarket

import android.app.Application
import com.example.onlinemarket.utils.ImageLoaderUtils


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        ImageLoaderUtils.initConfigration(this)
    }

    companion object {
        private var instance: MyApplication? = null
        fun instance() = instance!!
    }
}