package com.zing.ablue.login.activity;

import android.webkit.WebSettings;
import android.webkit.WebView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zing.ablue.R;
import com.zing.ablue.common.activity.BaseActivity;

import butterknife.BindView;


/**
 * Created by zing on 2016/12/8.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_bg_view) WebView webView;

    @Override
    public int initContentView() {
        return R.layout.login_login_aty;
    }

    @Override
    public void initData() {
        Fresco.initialize(this);
        setUpWebView();
    }


    private void setUpWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/webpage/login_canvas_wbv.html");
    }

}
