package com.zing.ablue.mainpage.fragment.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zing.ablue.R;
import com.zing.ablue.mainpage.fragment.adapter.entity.SettingItem;

import java.util.List;

/**
 * Created by zing on 2017/1/21.
 */

public class SettingMenuAdapter extends BaseAdapter {

    List<SettingItem> itemList;
    Activity activity;
    LayoutInflater inflater;

    public SettingMenuAdapter(List<SettingItem> itemList, Activity a) {
        this.itemList = itemList;
        this.activity = a;
        inflater = LayoutInflater.from(a);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public SettingItem getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
//        Log.v("BaseAdapterTest", "getView " + i + " " + convertView);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.main_page_setting_list_item_lis, null);
            holder = madContentViewBeHold(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag(); //取出ViewHolder对象
        }
        Log.i("#########", "" + holder);

        fixUpHolder(itemList.get(i), holder);

        return convertView;
    }

    private void fixUpHolder(SettingItem settingItem, ViewHolder holder) {
        if (settingItem.isGroupTitle()) {
            holder.splitLine.setVisibility(View.INVISIBLE);
        }
        Integer num = settingItem.getRemind();
        if (null == num || 0 >= num) {
            holder.remind.setVisibility(View.GONE);

        } else if (num > 99) {
            holder.remind.setText("99+");
        } else {
            holder.remind.setText(String.valueOf(num));
        }

        holder.icon.setText(settingItem.getIcon());
        holder.text.setText(settingItem.getText());
    }


    private ViewHolder madContentViewBeHold(View convertView) {
        ViewHolder holder = new ViewHolder();
                /*得到各个控件的对象*/
        holder.icon = (TextView) convertView.findViewById(R.id.main_page_setting_item_icon);
        holder.text = (TextView) convertView.findViewById(R.id.main_page_setting_item_text);
        holder.remind = (TextView) convertView.findViewById(R.id.main_page_setting_item_remind_number);
        holder.splitLine = (TextView) convertView.findViewById(R.id.main_page_setting_item_split_line);
        convertView.setTag(holder); //绑定ViewHolder对象
        return holder;
    }

    /*存放控件 的ViewHolder*/
    final class ViewHolder {
        public TextView icon;
        public TextView text;
        public TextView remind;
        public TextView splitLine;
    }

}

