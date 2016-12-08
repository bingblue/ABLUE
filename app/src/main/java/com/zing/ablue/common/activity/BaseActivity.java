package com.zing.ablue.common.activity;

import android.app.Activity;
import android.os.Bundle;

import com.zing.ablue.ZApplication;
import com.zing.ablue.common.utils.ActivityUtil;

/**
 * Created by zing on 2016/12/8.
 */

public class BaseActivity extends Activity {
    protected ZApplication application;

    private String TAG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (ZApplication) getApplication();
        TAG = this.getLocalClassName();

    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityUtil.add(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ActivityUtil.remove(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtil.remove(this);

    }

    public void showTip(String content) {
        ActivityUtil.showTip(content);
    }


}
