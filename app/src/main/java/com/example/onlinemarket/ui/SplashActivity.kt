package com.example.onlinemarket.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.onlinemarket.R
import com.example.onlinemarket.viewmodel.SplashViewModel
import org.litepal.LitePal
import java.lang.Thread.sleep


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LitePal.getDatabase()
        var splashViewModel =
            ViewModelProviders.of(this).get(SplashViewModel::class.java)
        Thread(Runnable {
            //耗时任务，比如加载网络数据
            runOnUiThread { // 这里可以睡几秒钟，如果要放广告的话
                sleep(1000)
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.anim_fade_in,R.anim.anim_fade_out)
                this@SplashActivity.finish()
                overridePendingTransition(R.anim.anim_fade_out,R.anim.anim_fade_in)
            }
        }).start()
    }
}