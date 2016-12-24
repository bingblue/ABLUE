package com.zing.ablue.login.activity;

import android.webkit.WebSettings;
import android.webkit.WebView;

import com.zing.ablue.R;
import com.zing.ablue.common.activity.PengLeActivity;

import butterknife.BindView;


/**
 * Created by zing on 2016/12/8.
 */

public class LoginActivity extends PengLeActivity {

    @BindView(R.id.login_bg_view)
    WebView webView;

    @Override
    protected void initView() {
        setContentView(R.layout.login_login_aty);
        setUpWebView();
    }

    @Override
    public void initData() {
    }

    @Override
    protected void initListener() {

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
