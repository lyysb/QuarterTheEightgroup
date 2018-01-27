package com.example.lyy.quartertheeightgroup.model.Imode;

import android.util.Log;

import com.example.lyy.quartertheeightgroup.model.bean.StainBean;
import com.example.lyy.quartertheeightgroup.model.http.AbstractObserver;
import com.example.lyy.quartertheeightgroup.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by LYY on 2018/1/25.
 */

public class SatinModel {
    public void getStainData(String page,final SatinCallBack satinCallBack){

        HashMap<String, String> map = new HashMap<>();
        map.put("source","android");
        map.put("appVersion","1");
        map.put("page",page);

        RetrofitUtils.getInstance().get("quarter/getJokes",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbstractObserver<StainBean>() {
                    @Override
                    public void onSuccess(StainBean stainBean) {
                        System.out.println("1222");
                        satinCallBack.Success(stainBean);
                    }

                    @Override
                    public void onFailure(int code) {
                        System.out.println("121");
                        //satinCallBack.faile(1);
                    }
                });

    }

}
