package com.example.onlinemarket.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinemarket.R

class UserViewModel : ViewModel() {

    val menu = MutableLiveData<Int>().apply { value = R.menu.user_menu }
    val username = MutableLiveData<String>().apply { value = "asdfas" }


}