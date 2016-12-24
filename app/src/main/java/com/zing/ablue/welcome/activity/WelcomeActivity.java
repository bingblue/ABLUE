package com.zing.ablue.welcome.activity;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zing.ablue.R;
import com.zing.ablue.common.activity.BaseActivity;
import com.zing.ablue.login.activity.LoginActivity;

import butterknife.BindView;

public class WelcomeActivity extends BaseActivity implements Animation.AnimationListener {

    @BindView(R.id.app_icon) ImageView icon;

    private boolean isWebWorkOver = false;
    private boolean isAnimationWorkOver = false;

    @Override
    public int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        Fresco.initialize(this);
        startAnimation();
        startPrepareBeforeMainActivityStart();
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
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

}
