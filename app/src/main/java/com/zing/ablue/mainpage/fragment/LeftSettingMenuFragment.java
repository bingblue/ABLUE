package com.zing.ablue.mainpage.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zing.ablue.R;
import com.zing.ablue.mainpage.fragment.adapter.SettingMenuAdapter;
import com.zing.ablue.mainpage.fragment.adapter.entity.SettingItem;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zing on 2017/1/20.
 */

public class LeftSettingMenuFragment extends Fragment {
    private View contentView;
    ImageView leftBackground;
    ImageView userHeadImg;
    ListView settingList;
    TextView settingMyApp;
    TextView exitMyApp;


    public static LeftSettingMenuFragment newInstance() {
        Bundle args = new Bundle();
        LeftSettingMenuFragment fragment = new LeftSettingMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        contentView = inflater.inflate(R.layout.main_page_news_frg, null, false);
        findViews(contentView);
        return contentView;
    }

    private void findViews(View v) {
        leftBackground = (ImageView) v.findViewById(R.id.main_page_menu_background);
        userHeadImg = (ImageView) v.findViewById(R.id.user_head);
        settingList = (ListView) v.findViewById(R.id.main_page_setting_list);
        settingMyApp = (TextView) v.findViewById(R.id.set_my_app);
        exitMyApp = (TextView) v.findViewById(R.id.exit_app);
    }


    @Override
    public void onStart() {
        super.onStart();
        setUpListView();
    }

    private void setUpListView() {
        SettingItem s1 = new SettingItem(true, "\uF004", "别点我，我不知道我能干啥", 1);
        SettingItem s2 = new SettingItem("\uF003", "别点我，我也不知道我能干啥");
        SettingItem s3 = new SettingItem(true, "", "哼，我是分组的");
        SettingItem s4 = new SettingItem("\uF006", "点我戳小牧菊花", 1000);
        SettingItem s5 = new SettingItem("\uF007", "点我，我戳不知道谁的菊花");
        List<SettingItem> itemList = Arrays.asList(s1, s2, s3, s4, s5);
        SettingMenuAdapter adapter = new SettingMenuAdapter(itemList, getActivity());
        settingList.setAdapter(adapter);
    }
}
