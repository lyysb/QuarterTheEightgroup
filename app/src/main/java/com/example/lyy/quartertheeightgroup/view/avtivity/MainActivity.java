package com.example.lyy.quartertheeightgroup.view.avtivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lyy.quartertheeightgroup.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends ImmersiveActivity {
    private int recLen = 1;
    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer.schedule(task, 1000, 1000);
    }


    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recLen--;
                    if (recLen < 0) {
                        timer.cancel();
                        Intent intent=new Intent(MainActivity.this,RecommendActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });


        }
    };
}
