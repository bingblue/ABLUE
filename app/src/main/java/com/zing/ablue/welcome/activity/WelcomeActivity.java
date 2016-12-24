package com.zing.ablue.welcome.activity;

import android.content.Intent;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zing.ablue.R;
import com.zing.ablue.common.activity.PengLeActivity;
import com.zing.ablue.login.activity.LoginActivity;
import com.zing.ablue.mainpage.activity.MainPageActivity;

import butterknife.BindView;

public class WelcomeActivity extends PengLeActivity implements Animation.AnimationListener {

    @BindView(R.id.app_icon)
    ImageView icon;

    private boolean isWebWorkOver = false;
    private boolean isAnimationWorkOver = false;


    @Override
    protected void initView() {
        Fresco.initialize(this);
        setContentView(R.layout.welcome_aty);
    }

    @Override
    public void initData() {
        startAnimation();
        startPrepareBeforeMainActivityStart();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        isAnimationWorkOver = true;
        startAppMainUiActivity();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    private void startPrepareBeforeMainActivityStart() {
        isWebWorkOver = true;
        startAppMainUiActivity();
    }

    private void startAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.icon_fade_in);
        animation.setAnimationListener(this);
        icon.startAnimation(animation);
    }


    private void startAppMainUiActivity() {
        if (isWebWorkOver && isAnimationWorkOver) {
            Intent intent = new Intent(this, MainPageActivity.class);
            startActivity(intent);
        }
    }

}
