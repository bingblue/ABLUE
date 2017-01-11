package com.zing.ablue.common.activity;

import android.os.Bundle;


public abstract class PengLeActivity extends BaseActivity {

    public static final String BASE_URL = "http://www.bingblue.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(initContentViewId());
            initData();
        } catch (Exception e) {
            e.printStackTrace();
            showTip("初始化异常！");
        }
    }

    protected abstract int initContentViewId();

    protected abstract void initData();

}
