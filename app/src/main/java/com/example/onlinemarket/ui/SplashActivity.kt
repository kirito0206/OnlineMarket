package com.example.onlinemarket.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.lang.Thread.sleep


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread(Runnable {
            //耗时任务，比如加载网络数据
            runOnUiThread { // 这里可以睡几秒钟，如果要放广告的话
                sleep(2000)
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                this@SplashActivity.finish()
            }
        }).start()
    }
}