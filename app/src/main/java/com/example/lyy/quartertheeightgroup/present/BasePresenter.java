package com.example.lyy.quartertheeightgroup.present;

/**
 * Created by LYY on 2018/1/23.
 */

public class BasePresenter<V> {
    public V view;

    public void attach(V v) {
        this.view = v;
    }

    public void detach() {
        this.view = null;
    }
}
