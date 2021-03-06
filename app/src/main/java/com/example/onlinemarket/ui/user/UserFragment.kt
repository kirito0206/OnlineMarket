package com.example.onlinemarket.ui.user

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.onlinemarket.R
import com.example.onlinemarket.databinding.FragmentUserBinding
import com.example.onlinemarket.ui.LoginActivity
import com.example.onlinemarket.utils.SPUtils

class UserFragment : Fragment() {

    private lateinit var userBinding : FragmentUserBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        userViewModel =
                ViewModelProviders.of(this).get(UserViewModel::class.java)
        userBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_user,container,false)
        userBinding.data = userViewModel
        userBinding.lifecycleOwner = this
        if (SPUtils.account.toString() == ""){
            val intent = Intent(context, LoginActivity::class.java)
            this.startActivity(intent)
        }
        return userBinding.root
    }
}