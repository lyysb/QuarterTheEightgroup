package com.example.lyy.quartertheeightgroup.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lyy.quartertheeightgroup.R;
import com.example.lyy.quartertheeightgroup.model.bean.AdvertBean;
import com.example.lyy.quartertheeightgroup.present.HotPresent;
import com.example.lyy.quartertheeightgroup.view.Iview.HotView;
import com.google.gson.Gson;
import com.youth.banner.Banner;

/**
 * Created by LYY on 2018/1/22.
 */

public class HotFragment extends Fragment implements HotView {

    private View view;
    private Banner banner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        HotPresent hotPresent = new HotPresent(this);
        System.out.println("11111111231111"+"123132111231");
        hotPresent.getHotData();

        Bundle bundle = getArguments();
        String string = bundle.getString("name", "rm");
       if (string.equals("rm")) {
           view = inflater.inflate(R.layout.hot_fragment, container, false);
           banner = view.findViewById(R.id.banner);




        } else if (string.equals("gz")) {

        }
        return view;
    }


   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }*/

    @Override
    public void onSuccess(AdvertBean advertBean) {
        Toast.makeText(getActivity(), "123"+advertBean.toString(), Toast.LENGTH_SHORT).show();

    }
}
