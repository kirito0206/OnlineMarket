package com.example.onlinemarket.viewmodel

import androidx.lifecycle.ViewModel
import com.example.onlinemarket.model.bean.Action
import com.example.onlinemarket.model.network.repository.MarketRepository
import com.example.onlinemarket.utils.SPUtils
import com.example.onlinemarket.utils.debug
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashViewModel : ViewModel() {

    private val marketRepository by lazy { MarketRepository() }.also { loadDatas() }

    fun loadDatas() {
        GlobalScope.launch(Dispatchers.Main) {
            initActionsData()
            initBanners()
        }
    }

    private suspend fun initActionsData(){
        val result = withContext(Dispatchers.IO){
            marketRepository.getActions()
        }
        if (result!!.status == 0){
            if (result.data.activities != null) {
            }
        }
    }

    private suspend fun initBanners() {
        val result = withContext(Dispatchers.IO){
            marketRepository.getBanners()
        }
        debug(result.toString())
        if (result!!.status == 0){
            if (result.data.message.type == null)
                SPUtils.bannerType = 0
            else
                SPUtils.bannerType = result.data.message.type
            if (result.data.message.picture != null) {
            }
        }
    }
}