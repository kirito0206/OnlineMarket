package com.example.onlinemarket.ui.user

import android.app.Activity
import android.content.Context
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinemarket.R
import com.example.onlinemarket.generated.callback.OnClickListener
import com.example.onlinemarket.model.bean.CommonResponse
import com.example.onlinemarket.model.network.repository.UserRepository
import com.example.onlinemarket.utils.SPUtils
import com.example.onlinemarket.utils.debug
import com.example.onlinemarket.utils.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel() : ViewModel(){

    val menu = MutableLiveData<Int>().apply { value = R.menu.user_menu }

    val response = MutableLiveData<CommonResponse>()
    val userName = MutableLiveData<String>().apply { if (SPUtils.account.toString() != "")value = SPUtils.account.toString() }
    val passWord = MutableLiveData<String>()
    private val repository by lazy { UserRepository() }


    fun loadDatas(view: View){
        GlobalScope.launch(Dispatchers.Main) {
            login(view.context)
        }
        // Do an asynchronous operation to fetch users.
    }

    suspend fun login(context: Context){
        if (response.value != null){
            return
        }
        val result = withContext(Dispatchers.IO){
            //repository.getPersonDetail(SPUtils.getData(context,SPUtils.USER_FILE,SPUtils.UserKey.USER_TOKEN,"") as String)
            repository.login(userName.value.toString(),passWord.value.toString())
        }
        debug(result.toString())
        response.value = result
        if (response.value == null){
            debug("获取信息失败，请检查网络！！")
            return
        }
        if (response.value!!.status == 0){
            SPUtils.account = userName.value.toString()
            SPUtils.password = passWord.value.toString()
            SPUtils.token = result.data.token
            toast(context,"登陆成功！！")
            (context as Activity).finish()
        }
        else{
            toast(context,"密码错误")
        }
    }
}
