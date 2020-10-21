package com.example.onlinemarket

import android.app.Application
import com.example.onlinemarket.utils.ImageLoaderUtils
import org.litepal.LitePal


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        LitePal.initialize(this)
        ImageLoaderUtils.initConfigration(this)
    }

    companion object {
        private var instance: MyApplication? = null
        fun instance() = instance!!
    }
}