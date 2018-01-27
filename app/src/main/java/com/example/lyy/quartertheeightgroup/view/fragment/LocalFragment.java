package com.example.lyy.quartertheeightgroup.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyy.quartertheeightgroup.R;

/**
 * Created by LYY on 2018/1/23.
 */

public class LocalFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.localfragment, container, false);
        return view;
    }
}
