package com.example.lyy.quartertheeightgroup.view.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.lyy.quartertheeightgroup.R;
import com.example.lyy.quartertheeightgroup.model.bean.StainBean;
import com.example.lyy.quartertheeightgroup.present.StainPresent;
import com.example.lyy.quartertheeightgroup.view.Iview.StainView;
import com.example.lyy.quartertheeightgroup.view.adapter.StainAdapter;
import com.example.lyy.quartertheeightgroup.view.avtivity.MainActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by LYY on 2018/1/22.
 * 段子页面
 */

public class SatinFragment extends Fragment implements StainView {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    Unbinder unbinder;
    private StainAdapter stainAdapter;
    private String page = "1";
    private SwipeRefreshLayout swipe;
    private PopupWindow mPopWindow;
    private int num = 0;
    private ImageView image;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.satin_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        swipe = view.findViewById(R.id.swipe);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


                swipe.setRefreshing(false);

                init();
            }


        });

        init();


        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        //绑定适配器

        stainAdapter = new StainAdapter(getActivity());
        recyclerView.setAdapter(stainAdapter);

        stainAdapter.setOnItemClickListener(new StainAdapter.OnItemClickListener() {



            @Override
            public void onItemClick(View view, int position) {
                image = view.findViewById(R.id.d_image);

                    image.setImageResource(R.drawable.breduce);





                showPopupWindow(view);

            }

            private void showPopupWindow(final View vvv) {
                View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.photo_popup_layout, null);
                mPopWindow = new PopupWindow(contentView,
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                mPopWindow.setContentView(contentView);
                mPopWindow.setAnimationStyle(R.style.AnimationPreview);
                ColorDrawable dw = new ColorDrawable(0000000000);
                mPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                       ImageView image = vvv.findViewById(R.id.d_image);

                        image.setImageResource(R.drawable.badd);
                    }
                });
                contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
                int  mShowMorePopupWindowWidth = -contentView.getMeasuredWidth();
                int  mShowMorePopupWindowHeight = -contentView.getMeasuredHeight();
                mPopWindow.showAsDropDown(vvv,mShowMorePopupWindowWidth, mShowMorePopupWindowHeight);

            }
        });

        stainAdapter.setOnItemClickListener1(new StainAdapter.OnItemClickListener1() {
            @Override
            public void onItemClick1(View view, int position) {
                Toast.makeText(getActivity(), "123123", Toast.LENGTH_SHORT).show();
            }
        });

    }




    private void init() {
        StainPresent present = new StainPresent(this);
        present.getSatinData(page);
    }

    @Override
    public void onSuccess(StainBean stainBean) {
        Log.i("--------", "add: " + "ok");
        if (stainBean != null) {
            stainAdapter.add(stainBean);
            stainAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
