package com.example.onlinemarket.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinemarket.R
import com.example.onlinemarket.model.bean.Action
import com.example.onlinemarket.model.bean.BannerResponse
import com.example.onlinemarket.model.bean.Product
import com.example.onlinemarket.model.network.repository.MarketRepository
import com.example.onlinemarket.utils.SPUtils
import com.example.onlinemarket.utils.debug
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.litepal.LitePal


class
HomeViewModel : ViewModel() {

    private val gridPicList0 = arrayListOf(
        R.drawable.pic0,
        R.drawable.pic1,
        R.drawable.pic2,
        R.drawable.pic3,
        R.drawable.pic4,
        R.drawable.pic5,
        R.drawable.pic6,
        R.drawable.pic7,
        R.drawable.pic8,
        R.drawable.pic9)
    private val gridPicList1 = arrayListOf(
        R.drawable.pic00,
        R.drawable.pic01,
        R.drawable.pic02,
        R.drawable.pic03,
        R.drawable.pic04,
        R.drawable.pic05,
        R.drawable.pic06,
        R.drawable.pic07,
        R.drawable.pic08,
        R.drawable.pic09)
    val actionTitle0 = MutableLiveData<String>().apply { value = "在这美好的秋季与您相约，“花好月圆人团圆、盛隆送礼礼连礼”与您共度中秋、国庆佳节。感受秋天带来收获与成熟的风韵。" }
    val actionTitle1 = MutableLiveData<String>().apply { value = "欢乐节日劲爆优惠大行动!海报换礼品，剪角来就送!开心圣诞节!狂购风暴，圣诞元旦先下手为强。"}

    private val marketRepository by lazy { MarketRepository() }

    //GridView
    val picList = MutableLiveData<ArrayList<Int>>().apply { value = arrayListOf() }
    val nameList = MutableLiveData<ArrayList<String>>().apply { value = arrayListOf() }

    //活动
    val action = MutableLiveData<Action>().apply {
        var list = LitePal.findAll(Action::class.java)
        value = if(list.isNullOrEmpty()){
            null
        }else
            list[0]
    }

    //推荐商品
    val recommendList = MutableLiveData<ArrayList<Product>>().apply { value = arrayListOf() }

    //中秋商品
    val activityproductList = MutableLiveData<ArrayList<Product>>().apply { value = arrayListOf() }

    //轮播图
    var bannerPic = MutableLiveData<ArrayList<String>>().apply { value = arrayListOf() }
    var bannerType = MutableLiveData<Int>().apply { value = 0 }
    private val response = MutableLiveData<BannerResponse>().also { loadDatas() }
    var actionId = 1

    fun loadDatas() {
        initGridData()
        GlobalScope.launch(Dispatchers.Main) {
            initBanners()

            if (SPUtils.token.isNotEmpty()){
                //initRecyclerData()
                initActicityRecyclerData()
                initRecommend()
            }

        }
    }

    private suspend fun initActicityRecyclerData(){
        if(action.value == null)
            return
        val result = withContext(Dispatchers.IO){
            marketRepository.getSingleAction(SPUtils.token, action.value!!.actionId)
        }
        if (result!!.status == 0){
            if (result.data.message.product != null) {
                activityproductList.value = result.data.message.product as ArrayList<Product>
            }
        }
    }


    private fun initGridData() {
        if (action.value?.type == 2)
            picList.value = gridPicList1
        else
            picList.value = gridPicList0
        nameList.value?.add("水果")
        nameList.value?.add("蔬菜")
        nameList.value?.add("肉禽蛋品")
        nameList.value?.add("海鲜水产")
        nameList.value?.add("粮油调味")
        nameList.value?.add("熟食卤味")
        nameList.value?.add("冰品面点")
        nameList.value?.add("牛奶面包")
        nameList.value?.add("酒水冲饮")
        nameList.value?.add("休闲零食")
    }

    private suspend fun initBanners() {
        val result = withContext(Dispatchers.IO){
            marketRepository.getBanners()
        }
        response.value = result
        debug(result.toString())
        if (result!!.status == 0){
            bannerType.value = result.data.message.type?:0
            if (result.data.message.picture != null) {
                bannerPic.value = response!!.value!!.data.message.picture
            }
        }
    }

    private suspend fun initRecommend() {
        val result = withContext(Dispatchers.IO){
            marketRepository.getRecommendProducts(SPUtils.token)
        }
        debug(result.toString())
        if (result!!.status == 0){
            if (result.data.message != null) {
                recommendList.value = result.data.message as ArrayList<Product>
            }
        }
    }
}