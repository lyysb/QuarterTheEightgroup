package com.example.lyy.quartertheeightgroup.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyy.quartertheeightgroup.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by LYY on 2018/1/22.
 * 视屏页面
 */

public class VideoFragment extends Fragment {


    @BindView(R.id.v_tab)
    TabLayout vTab;
    @BindView(R.id.v_vp)
    ViewPager vVp;
    Unbinder unbinder;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        list = new ArrayList<>();
        list.add("热门");
        list.add("附近");
        vVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {

            //获得标题


            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {

                NearByFragment nearByFragment = new NearByFragment();
                Bundle bundle = new Bundle();
                if (list.get(position).equals("热门")) {
                    bundle.putString("nmae", "vrm");
                } else if (list.get(position).equals("附近")) {
                    bundle.putString("name", "fj");
                }
                nearByFragment.setArguments(bundle);
                return nearByFragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        vTab.setupWithViewPager(vVp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
