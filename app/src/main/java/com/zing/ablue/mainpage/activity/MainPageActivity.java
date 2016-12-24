package com.zing.ablue.mainpage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.zing.ablue.R;
import com.zing.ablue.mainpage.fragment.MainPageFragment;
import com.zing.ablue.mainpage.fragment.MainPageViewPagerFragment;
import com.zing.zinglibrary.navigation_liveo.interfaces.OnItemClickListener;
import com.zing.zinglibrary.navigation_liveo.interfaces.OnPrepareOptionsMenuLiveo;
import com.zing.zinglibrary.navigation_liveo.model.HelpLiveo;
import com.zing.zinglibrary.navigation_liveo.navigationliveo.NavigationLiveo;

public class MainPageActivity extends NavigationLiveo implements OnItemClickListener {

    private HelpLiveo mHelpLiveo;

    @Override
    public void onInt(Bundle savedInstanceState) {

        // User Information
        this.userName.setText("Rudson Lima");
        this.userEmail.setText("rudsonlive@gmail.com");
        this.userPhoto.setImageResource(R.drawable.ic_rudsonlive);
        this.userBackground.setImageResource(R.drawable.ic_user_background_first);

        // Creating items navigation
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.inbox), R.mipmap.ic_inbox_black_24dp, 7);
        mHelpLiveo.addSubHeader(getString(R.string.categories)); //Item subHeader
        mHelpLiveo.add(getString(R.string.starred), R.mipmap.ic_star_black_24dp);
        mHelpLiveo.add(getString(R.string.sent_mail), R.mipmap.ic_send_black_24dp);
        mHelpLiveo.addNoCheck(getString(R.string.drafts), R.mipmap.ic_drafts_black_24dp);
        mHelpLiveo.addSeparator(); //Item separator
        mHelpLiveo.add(getString(R.string.trash), R.mipmap.ic_delete_black_24dp);
        mHelpLiveo.add(getString(R.string.spam), R.mipmap.ic_report_black_24dp, 120);

        //{optional} - Header Customization - method customHeader
        //View mCustomHeader = getLayoutInflater().inflate(R.layout.custom_header_user, this.getListView(), false);
        //ImageView imageView = (ImageView) mCustomHeader.findViewById(R.id.imageView);

        with(this).startingPosition(2) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())
                //{optional} - List Customization "If you remove these methods and the list will take his white standard color"
                //.selectorCheck(R.drawable.selector_check) //Inform the background of the selected item color
                //.colorItemDefault(R.color.nliveo_blue_colorPrimary) //Inform the standard color name, icon and counter
                .colorItemSelected(R.color.nliveo_blue_colorPrimary) //State the name of the color, icon and meter when it is selected
                //.backgroundList(R.color.nliveo_black_light) //Inform the list of background color
                //.colorLineSeparator(R.color.nliveo_transparent) //Inform the color of the subheader line

                //{optional} - SubHeader Customization
                //.colorNameSubHeader(R.color.nliveo_blue_colorPrimary)
                //.colorLineSeparator(R.color.nliveo_green_colorPrimaryDark)

                //.removeFooter()
                .footerItem(R.string.settings, R.mipmap.ic_settings_black_24dp)

                //{optional} - Second footer
                //.footerSecondItem(R.string.settings, R.drawable.ic_settings_black_24dp)

                //{optional} - Header Customization
                //.customHeader(mCustomHeader)

                //{optional} - Footer Customization
                //.footerNameColor(R.color.nliveo_blue_colorPrimary)
                //.footerIconColor(R.color.nliveo_blue_colorPrimary)

                //.footerSecondNameColor(R.color.nliveo_blue_colorPrimary)
                //.footerSecondIconColor(R.color.nliveo_blue_colorPrimary)

                //.footerBackground(R.color.nliveo_white)

                //{optional} - Remove color filter icon
                //.removeColorFilter()

                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)

                //{optional} - Second footer
                //.setOnClickFooterSecond(onClickFooter)
                .build();

        int position = this.getCurrentPosition();
        this.setElevationToolBar(position != 2 ? 15 : 0);
    }

    @Override
    public void onItemClick(int position) {
        Fragment mFragment;
        FragmentManager mFragmentManager = getSupportFragmentManager();

        switch (position){
            case 2:
                mFragment = new MainPageViewPagerFragment();
                break;

            default:
                mFragment = MainPageFragment.newInstance(mHelpLiveo.get(position).getName());
                break;
        }

        if (mFragment != null){
            mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
        }

        setElevationToolBar(position != 2 ? 15 : 0);
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "onClickPhoto :D", Toast.LENGTH_SHORT).show();
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), SettingActivity.class));
            closeDrawer();
        }
    };
}
