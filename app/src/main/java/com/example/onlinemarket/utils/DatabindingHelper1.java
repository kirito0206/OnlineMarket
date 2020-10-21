package com.example.onlinemarket.utils;

import androidx.databinding.BindingAdapter;

import com.example.onlinemarket.adapter.BannerViewHolder;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;

import java.util.ArrayList;

public class DatabindingHelper1 {
    @BindingAdapter({"bannerList"})
    public static void loadBannerView(MZBannerView view,ArrayList<String> bannerList) {
        if (bannerList == null || bannerList.size() == 0)
            return;
        view.setPages(bannerList,new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
    }

    @BindingAdapter({"bannerType"})
    public static void setBannerType(MZBannerView view,Integer bannerType) {
        switch (bannerType){
            case 0:view.setCanLoop(true);view.setIndicatorAlign(MZBannerView.IndicatorAlign.CENTER);break;
            case 1:view.setCanLoop(false);view.setIndicatorAlign(MZBannerView.IndicatorAlign.RIGHT);break;
        }
    }
}