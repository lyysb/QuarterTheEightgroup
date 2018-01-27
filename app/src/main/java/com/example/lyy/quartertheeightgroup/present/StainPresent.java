package com.example.lyy.quartertheeightgroup.present;

import com.example.lyy.quartertheeightgroup.model.Imode.SatinCallBack;
import com.example.lyy.quartertheeightgroup.model.Imode.SatinModel;
import com.example.lyy.quartertheeightgroup.model.bean.StainBean;
import com.example.lyy.quartertheeightgroup.view.Iview.StainView;

/**
 * Created by LYY on 2018/1/25.
 */

public class StainPresent {



   public StainView stainView;
   public SatinModel satinModel;
   public   StainPresent(StainView stainView){

       this.stainView=stainView;
        satinModel = new SatinModel();
   }
   public  void getSatinData(String page){

       satinModel.getStainData(page,new SatinCallBack() {
           @Override
           public void Success(StainBean stainBean) {
               if (stainView!=null){
                   stainView.onSuccess(stainBean);
               }
           }

           @Override
           public void faile(Exception e) {
               if (stainView!=null){

               }
           }
       });

   }


}
