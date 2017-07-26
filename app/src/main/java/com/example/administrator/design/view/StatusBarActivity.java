package com.example.administrator.design.view;

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.design.R;
import com.example.administrator.design.utils.StatusBarUtil;

public class StatusBarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        * 设置状态栏颜色 StatusBarUtil.setColor(Activity activity, int color)
        * 设置状态栏半透明 StatusBarUtil.setTranslucent(Activity activity, int statusBarAlpha)
        * 设置状态栏全透明 StatusBarUtil.setTransparent(Activity activity)
        * 为包含DrawerLayout界面设置状态栏颜色（也可以设置半透明和全透明） StatusBarUtil.setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int color)
        * 为使用ImageView作为头部界面设置状态栏透明 StatusBarUtil.setTranslucentForImageView(Activity activity, int statusBarAlpha, View needOffsetView)
        * */
        StatusBarUtil.setTranslucent(StatusBarActivity.this, 0);
        setContentView(R.layout.activity_status_bar);
    }
}
