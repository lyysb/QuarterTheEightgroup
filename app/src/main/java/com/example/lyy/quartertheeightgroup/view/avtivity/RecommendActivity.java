package com.example.lyy.quartertheeightgroup.view.avtivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.slidingmenu.SlidingMenu;
import com.example.lyy.quartertheeightgroup.R;
import com.example.lyy.quartertheeightgroup.view.fragment.RecommendFragment;
import com.example.lyy.quartertheeightgroup.view.fragment.SatinFragment;
import com.example.lyy.quartertheeightgroup.view.fragment.VideoFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

//推荐
public class RecommendActivity extends ImmersiveActivity implements View.OnClickListener {


    private SlidingMenu slidingMenu;
    private SimpleDraweeView simp;
    private ImageView r_image;


    private static final String Recommend = "推荐";
    private static final String Satin = "段子";
    private static final String Video = "视频";
    private BottomTabBar bar;
    private ImageView image1;
    private ImageView image2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        ButterKnife.bind(this);


        slidingMenu = new SlidingMenu(this);
        //设置相关属性
        slidingMenu.setMode(SlidingMenu.LEFT);//菜单靠左
  //      slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//全屏支持触摸拖拉
        slidingMenu.setBehindOffset(350);//SlidingMenu划出时主页面显示的剩余宽度
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);//不包含ActionBar
        slidingMenu.setMenu(R.layout.left_content);//设置侧滑里的布局
        //设置透明度
        slidingMenu.setFadeDegree(1f);

        initview();
    }

    private void initview() {

        simp = findViewById(R.id.simp);
        r_image = findViewById(R.id.r_image);

        //侧滑布局里的id
        image1 = slidingMenu.findViewById(R.id.image1);
        image2 = slidingMenu.findViewById(R.id.image2);


        simp.setOnClickListener(this);
        r_image.setOnClickListener(this);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        bar = findViewById(R.id.bar);
        bar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(15)
                .setChangeColor(Color.BLUE, Color.GRAY)
                //加载Fragment参数，分别是图片下面的文字，选中时候的图片，未选中时候的图片，对应的Fragment类
                .addTabItem(Recommend, R.drawable.ryes, R.drawable.rno, RecommendFragment.class)
                .addTabItem(Satin, R.drawable.fn, R.drawable.fs, SatinFragment.class)
                .addTabItem(Video, R.drawable.vyes, R.drawable.vno, VideoFragment.class)
                .isShowDivider(false);




    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //重写了Menu监听，实现按下手机Menu键弹出和关闭侧滑菜单
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            slidingMenu.toggle();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simp:
                slidingMenu.toggle();
                break;
            case R.id.r_image:
                //编辑跳转
                Intent intent = new Intent(RecommendActivity.this, EdxitActivity.class);
                startActivity(intent);

                break;
            case R.id.image1:
                //编辑跳转
                Intent intent1 = new Intent(RecommendActivity.this, MyWorkActivity.class);
                startActivity(intent1);

                break;
            case R.id.image2:
                //编辑跳转
                Intent intent2 = new Intent(RecommendActivity.this, SetActivity.class);
                startActivity(intent2);

                break;
            default:
                break;
        }
    }
}
