package com.example.lyy.quartertheeightgroup.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lyy.quartertheeightgroup.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LYY on 2018/1/22.
 * 推荐页面
 */

public class RecommendFragment extends Fragment {

    private List<String> list;
    private TabLayout tab1;
    private ViewPager vp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommend_fragment, container, false);
        tab1 = view.findViewById(R.id.tab);
        vp = view.findViewById(R.id.vp);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = new ArrayList<>();
        list.add("热门");
        list.add("关注");
        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            //得到当前标题
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
            @Override
            public Fragment getItem(int position) {
                HotFragment hotFragment = new HotFragment();
                Bundle bundle = new Bundle();
                if (list.get(position).equals("热门")) {
                    bundle.putString("name", "rm");
                } else if (list.get(position).equals("关注")) {
                    bundle.putString("name", "gz");
                }

                hotFragment.setArguments(bundle);
                return hotFragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        //tablayout要与viewpager关联
        tab1.setupWithViewPager(vp);

    }
}
