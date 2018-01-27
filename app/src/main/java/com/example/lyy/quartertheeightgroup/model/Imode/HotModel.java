package com.example.lyy.quartertheeightgroup.model.Imode;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.lyy.quartertheeightgroup.R;
import com.example.lyy.quartertheeightgroup.model.Imode.HotCallBack;
import com.example.lyy.quartertheeightgroup.model.bean.AdvertBean;
import com.example.lyy.quartertheeightgroup.model.http.APIFactory;
import com.example.lyy.quartertheeightgroup.model.http.AbstractObserver;
import com.example.lyy.quartertheeightgroup.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by LYY on 2018/1/24.
 */

public class HotModel {

    public void hotData(final HotCallBack hotCallBack) {

        RetrofitUtils.getInstance().get("quarter/getAd")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbstractObserver<AdvertBean>() {
                    @Override
                    public void onSuccess(AdvertBean advertBean) {
                        hotCallBack.Success(advertBean);
                    }

                    @Override
                    public void onFailure(int code) {

                    }
                });

    }
}
