package com.example.lyy.quartertheeightgroup.model.Imode;

import com.example.lyy.quartertheeightgroup.model.bean.AdvertBean;

/**
 * Created by LYY on 2018/1/24.
 */

public interface HotCallBack {

void  Success(AdvertBean advertBean);
void faile(Exception e);
}
