package com.example.lyy.quartertheeightgroup.present;

import android.support.v4.app.FragmentActivity;

import com.example.lyy.quartertheeightgroup.model.Imode.HotCallBack;
import com.example.lyy.quartertheeightgroup.model.Imode.HotModel;
import com.example.lyy.quartertheeightgroup.model.bean.AdvertBean;
import com.example.lyy.quartertheeightgroup.view.Iview.HotView;

/**
 * Created by LYY on 2018/1/24.
 */

public class HotPresent {


    private final HotView hotView;
    private final HotModel hotModel;

    public HotPresent(HotView hotView) {
        this.hotView = hotView;
        hotModel = new HotModel();
    }





    public void  getHotData(){

        hotModel.hotData(new HotCallBack() {
            @Override
            public void Success(AdvertBean advertBean) {
                if (hotView!=null){
                   hotView.onSuccess(advertBean);
                    System.out.println("11111111231111刘宇洋"+"123132111231");
                }
            }

            @Override
            public void faile(Exception e) {

            }
        });
    }

    //防止内存泄漏


}
