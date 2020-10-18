package com.example.onlinemarket.ui

import android.database.DatabaseUtils
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.onlinemarket.R
import com.example.onlinemarket.databinding.ActivityLoginBinding
import com.example.onlinemarket.databinding.FragmentUserBinding
import com.example.onlinemarket.ui.user.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater

class LoginActivity: AppCompatActivity() {
    private lateinit var userBinding : ActivityLoginBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel =
                ViewModelProviders.of(this).get(UserViewModel::class.java)
        userBinding = DataBindingUtil.inflate(layoutInflater,R.layout.activity_login,container,false)
        userBinding.data = userViewModel
        userBinding.lifecycleOwner = this
        setContentView(userBinding.root)
    }
}