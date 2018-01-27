package com.example.lyy.quartertheeightgroup.view.avtivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lyy.quartertheeightgroup.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PublishActivity extends ImmersiveActivity {

    @BindView(R.id.back)
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back)
    public void onClick() {

        Intent intent = new Intent(PublishActivity.this, MyWorkActivity.class);
        startActivity(intent);
    }
}
