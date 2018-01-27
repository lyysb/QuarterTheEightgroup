package com.example.lyy.quartertheeightgroup.model.Imode;

import com.example.lyy.quartertheeightgroup.model.bean.StainBean;

/**
 * Created by LYY on 2018/1/25.
 */

public interface SatinCallBack {


    void Success(StainBean stainBean);
    void faile(Exception e);
}
