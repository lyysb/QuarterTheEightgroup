package com.example.lyy.quartertheeightgroup.view.avtivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.lyy.quartertheeightgroup.R;
import com.example.lyy.quartertheeightgroup.view.fragment.LocalFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyWorkActivity extends ImmersiveActivity {

    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.m_tab)
    TabLayout mTab;
    @BindView(R.id.m_vp)
    ViewPager mVp;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_work);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        list=new ArrayList<String>();
        list.add("本地作品");
        list.add("已上传");

        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {

                LocalFragment localFragment = new LocalFragment();
                Bundle bundle = new Bundle();
                if (list.get(position).equals("本地作品")) {
                    bundle.putString("name", "zp");

                } else if (list.get(position).equals("已上传")) {
                    bundle.putString("name", "sc");
                }
                localFragment.setArguments(bundle);
                return localFragment;


            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        mTab.setupWithViewPager(mVp);

    }
}
