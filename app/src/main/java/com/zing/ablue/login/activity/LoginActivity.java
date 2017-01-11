package com.zing.ablue.login.activity;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zing.ablue.R;
import com.zing.ablue.common.activity.PengLeActivity;
import com.zing.ablue.login.network.entities.HttpResultEntity;
import com.zing.ablue.login.network.entities.LoginRequestEntity;
import com.zing.ablue.login.network.servicies.LoginRequest;
import com.zing.zinglibrary.http.HttpUtil;
import com.zing.zinglibrary.http.RequestCallback;
import com.zing.zinglibrary.http.http_client.DefaultOkHttpClient;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;


/**
 * Created by zing on 2016/12/8.
 * 登录页面
 */
public class LoginActivity extends PengLeActivity {

    private boolean isExit = false;
    private Timer exitTimer = new Timer();
    private TimerTask exitTask ;

    @BindView(R.id.login_bg_view) WebView webView;

    @BindView(R.id.ed_userName) EditText ed_userName;

    @BindView(R.id.ed_userPwd) EditText ed_userPwd;

    @BindView(R.id.ed_code) EditText ed_code;

    @BindView(R.id.btn_invitation) Button btn_Login;

    @BindView(R.id.btn_get_invite) Button btn_get_invite;

    @Override
    protected int initContentViewId() {
        return R.layout.login_login_aty;
    }

    @Override
    public void initData() {
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

    @OnClick(R.id.btn_invitation) public void onLoginClick(){
        LoginRequestEntity loginRequestEntity = new LoginRequestEntity();
        loginRequestEntity.setLoginIp(getLocalIpAddress(this));
        loginRequestEntity.setUserName(ed_userName.getText().toString().trim());
        loginRequestEntity.setUserPwd(ed_userPwd.getText().toString().trim());
        loginRequestEntity.setInvitationCode(ed_code.getText().toString().trim());
        String msg = loginRequestEntity.checkSelf();

        if(!TextUtils.isEmpty(msg)){
            showTip(msg);
            return;
        }

        RequestCallback<HttpResultEntity<String>> callback = createCallBack();

        CookieJar cookieJar = DefaultOkHttpClient.getDefaultCookieJar(this);

        HttpUtil httpUtil = HttpUtil.getInstance();

        OkHttpClient client = DefaultOkHttpClient.getOkHttpClient(true, this, null, cookieJar);

        LoginRequest loginRequest = httpUtil.buildJSONRequest(BASE_URL, LoginRequest.class, client);

        httpUtil.sendRequest(loginRequest.login(loginRequestEntity), callback);
    }

    @OnClick(R.id.btn_get_invite)public void getInviteCode(){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private RequestCallback<HttpResultEntity<String>> createCallBack() {
        return new RequestCallback<HttpResultEntity<String>>(){

            @Override
            public void onStart() {
                Log.i("LoginActivity", "onStart: ");
            }

            @Override
            public void onResponse(HttpResultEntity<String> o) {
                String body = o.getBody();
                if (o.getCode() == 1500){
                    Toast.makeText(LoginActivity.this,o.getMsg(),Toast.LENGTH_SHORT).show();
                }else {
                    // TODO: 2017/1/11 登录成功
                    //Intent intent=new Intent(this,MainActivity.class);
                    //startActivity(intent);
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ", e);
            }

            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted:");
            }
        };
    }

    /**
     * 将ip的整数形式转换成ip形式
     * @param ipInt
     * @return
     */
    public String int2ip(int ipInt) {
        StringBuilder sb = new StringBuilder();
        sb.append(ipInt & 0xFF).append(".");
        sb.append((ipInt >> 8) & 0xFF).append(".");
        sb.append((ipInt >> 16) & 0xFF).append(".");
        sb.append((ipInt >> 24) & 0xFF);
        return sb.toString();
    }

    /**
     * 获取当前ip地址
     * @param context
     * @return
     */
    public String getLocalIpAddress(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context
                    .getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            int i = wifiInfo.getIpAddress();
            return int2ip(i);
        } catch (Exception ex) {
            return " 获取IP出错鸟!!!!请保证是WIFI,或者请重新打开网络!\n" + ex.getMessage();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!isExit) {
                isExit = true;
                Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                if (exitTask !=null ){
                    exitTask.cancel();
                }
                exitTask = new TimerTask() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                };
                exitTimer.schedule(exitTask, 2000);
            } else {
                finish();
                System.exit(0);
            }
        }
        return true;
    }


}
