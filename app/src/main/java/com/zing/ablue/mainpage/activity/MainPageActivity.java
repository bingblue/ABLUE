package com.zing.ablue.mainpage.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zing.ablue.R;
import com.zing.ablue.common.activity.BaseAppCompatActivity;
import com.zing.ablue.mainpage.fragment.LeftSettingMenuFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainPageActivity extends BaseAppCompatActivity {
    @BindView(R.id.go_main_page_btn)
    LinearLayout mainPageBtn;
    @BindView(R.id.go_find_something_btn)
    LinearLayout findSomethingBtn;
    @BindView(R.id.go_find_service_btn)
    LinearLayout serviceBtn;
    @BindView(R.id.main_page_drawer_layout)
    DrawerLayout mainPageDrawerLayout;
    @BindView(R.id.main_page_main_frg_container)
    FrameLayout mainFragmentLayout;
    @BindView(R.id.main_page_left_frg_lay)
    FrameLayout settingFragmentLayout;
    @BindView(R.id.main_page_title)
    TextView mainPageTitle;
    @BindView(R.id.main_page_toolbar)
    Toolbar toolbar;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    private LeftSettingMenuFragment menuFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_box_aty);
        init();
        goMainPage(mainPageBtn);


    }

    private void init() {
        setUpToobar();
        setUpMenuFragment();


    }

    private void setUpMenuFragment() {
//        menuFragment = new LeftSettingMenuFragment(this);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_page_left_frg_lay, LeftSettingMenuFragment.newInstance());
        transaction.commit();
    }

    private void setUpToobar() {
        mainPageTitle.setText("首页");
        toolbar.setTitle("");
        toolbar.setTitleTextColor(Color.rgb(255, 255, 255));
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, mainPageDrawerLayout, toolbar, R.string.mainpage_drawerlayout_open, R.string.mainpage_drawerlayout_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        actionBarDrawerToggle.syncState();
        mainPageDrawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

    @OnClick(R.id.go_main_page_btn)
    protected void goMainPage(View view) {
        focusViews(mainPageBtn);
    }

    @OnClick(R.id.go_find_something_btn)
    protected void goFindSomething(View view) {
        focusViews(findSomethingBtn);
    }

    @OnClick(R.id.go_find_service_btn)
    protected void goServiceYourself(View view) {
        focusViews(serviceBtn);
    }


    private void focusViews(ViewGroup viewGroup) {
        clearAllBtnColor();
        setViewsFocusColor(viewGroup);
    }

    protected void clearAllBtnColor() {
        List<View> views = getViews(mainPageBtn);
        views.addAll(getViews(findSomethingBtn));
        views.addAll(getViews(serviceBtn));
        for (View view : views) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(Color.rgb(96, 96, 96));
            }
        }
    }

    protected void setViewsFocusColor(ViewGroup viewGroup) {
        List<View> views = getViews(viewGroup);
        for (View view : views) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(Color.rgb(0, 166, 255));
            }
        }
    }

    private List<View> getViews(ViewGroup viewGroup) {
        int viewLen = viewGroup.getChildCount();
        if (0 >= viewLen) {
            return new ArrayList<>();
        } else {
            List<View> views = new ArrayList<>();
            for (int i = 0; i < viewLen; i++) {
                views.add(viewGroup.getChildAt(i));
            }
            return views;
        }
    }
}
