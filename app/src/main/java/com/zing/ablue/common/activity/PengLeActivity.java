package com.zing.ablue.common.activity;

import android.os.Bundle;


public abstract class PengLeActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            initView();
            initListener();
            initData();
        } catch (Exception e) {
            e.printStackTrace();
            showTip("初始化异常！");
        }
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();
}
