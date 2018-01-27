package com.example.lyy.quartertheeightgroup.view.avtivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lyy.quartertheeightgroup.R;
import com.example.lyy.quartertheeightgroup.present.BasePresenter;

public abstract class BaseMvpActivity<V, T extends BasePresenter<V>> extends Activity {

    public abstract T initPresenter();

    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_mvp);
        presenter = initPresenter();
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
