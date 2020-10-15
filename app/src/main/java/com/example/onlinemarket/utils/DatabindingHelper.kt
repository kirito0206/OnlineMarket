package com.example.onlinemarket.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.nostra13.universalimageloader.core.ImageLoader

class DatabindingHelper {

    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImage(iv: ImageView, url: String?) {
            ImageLoader.getInstance().displayImage(url, iv)
        }

        @BindingAdapter("resId")
        @JvmStatic
        fun loadMipmapResource(iv: ImageView, resId: Int) {
            iv.setImageResource(resId)
        }

        /*@BindingAdapter("gridlist")
        @JvmStatic
        fun loadGridView(gridView : GridView,animesList:MutableList<AnimeData>?) {
            if (animesList == null){
                debug("animelist : null")
                return
            }
            gridView.adapter = GridAdapter(animesList)
        }

        @BindingAdapter("commentslist")
        @JvmStatic
        fun loadRecyclerView(recyclerView: XRecyclerView,commentsList:MutableList<Comment>?) {
            if (commentsList == null){
                debug("commentsList : null")
                return
            }
            val layoutManager = LinearLayoutManager(recyclerView.context)
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = RecyclerCommentAdapter(commentsList)

            //设置是否允许下拉刷新
            recyclerView.setPullRefreshEnabled(false)
            //设置是否允许上拉加载
            recyclerView.setLoadingMoreEnabled(true)
            recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader)
            recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader)

            recyclerView.setLoadingListener(object : LoadingListener {
                //下拉刷新
                override fun onRefresh() {
                    //当下拉刷新的时候，重新获取数据，所有curr要变回0，并且把集合list清空
                    Handler().postDelayed(Runnable {
                        //curr = 1 //当前页码
                        /**加载数据处理 */
                        recyclerView.refreshComplete()
                    }, 2000)
                }

                //上拉加载
                override fun onLoadMore() {
                    Handler().postDelayed(Runnable {
                        //curr++ //当前页码
                        /**加载数据处理 */
                        /**加载数据处理 */
                        /**加载数据处理 */
                        /**加载数据处理 */
                        recyclerView.loadMoreComplete()
                    }, 2000)
                }
            })
        }*/

    }
}