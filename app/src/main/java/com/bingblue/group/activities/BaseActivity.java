package com.bingblue.group.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.bingblue.group.ZApplication;
import com.bingblue.group.utils.ActivityUtil;

/**
 * Created by Zing on 15/7/10.
 */
public class BaseActivity extends Activity {
    protected ZApplication application;

    protected void onCreate(Bundle savedInstanceState) {
        ActivityUtil.add(this);
        super.onCreate(savedInstanceState);
        application = (ZApplication) getApplication();
    }



    public void closeKeyBord(View editText) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0); //强制隐藏键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    protected void onDestroy() {
        ActivityUtil.remove(this);
        super.onDestroy();
    }


}
