package com.example.lyy.quartertheeightgroup.view.avtivity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.lyy.quartertheeightgroup.R;

import me.yokeyword.fragmentation.SupportActivity;

public class ImmersiveActivity extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersive);
        getSupportActionBar().hide();
      //  init();
    }

    private void init() {
        setTranslucentStatus(true);

        if (enableSliding()) {
            // SlidingLayout rootView = new SlidingLayout(this);
            //rootView.bindActivity(this);
        }
    }

    protected void setTranslucentStatus(boolean b) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (b) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }

    protected boolean enableSliding() {
        return true;
    }

}
