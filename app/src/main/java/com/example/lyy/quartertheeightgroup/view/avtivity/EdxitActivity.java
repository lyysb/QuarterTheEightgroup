package com.example.lyy.quartertheeightgroup.view.avtivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lyy.quartertheeightgroup.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EdxitActivity extends ImmersiveActivity {

    @BindView(R.id.simp_bj)
    ImageView simpBj;
    @BindView(R.id.simp_video)
    ImageView simpVideo;
    @BindView(R.id.e_text)
    TextView eText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edxit);
        ButterKnife.bind(this);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(EdxitActivity.this, RecommendActivity.class);
        startActivity(intent2);
            }
        });
    }

    @OnClick({R.id.simp_bj, R.id.simp_video})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.simp_bj:
                Intent intent = new Intent(EdxitActivity.this, SayActivity.class);
                startActivity(intent);
                break;
            case R.id.simp_video:

                Intent intent1 = new Intent(EdxitActivity.this, PhotoActivity.class);
                startActivity(intent1);
                break;

        }
    }


}
