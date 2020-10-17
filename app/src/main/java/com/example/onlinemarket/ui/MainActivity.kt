package com.example.onlinemarket.ui

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.onlinemarket.R
import kotlinx.android.synthetic.main.fragment_user.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home,
            R.id.navigation_classify,
            R.id.navigation_cart,
            R.id.navigation_user
        ))*/
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        setStatusBar(window,false)
    }

    //解决状态栏灰色遮罩
    //isLight参数，如果为true，就将状态栏的图标和文本设置成黑色。为false, 就变成白色。
    fun setStatusBar(window: Window, isLight: Boolean) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isLight) {
                window.clearFlags(
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                                or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                )

                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            } else {
                window.clearFlags(
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                                or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                                or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                )
                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            }

            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.BLACK
        }

        var height = resources.getIdentifier("status_bar_height", "dimen", "android")
    }
}