package com.example.administrator.design.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.design.R;

public class NavigationViewActivity extends Activity {
    /*声明控件*/
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);
        initView();
    }

    private void initView() {
        mNavigationView = findViewById(R.id.navigationView);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        // 获得头布局
        View view = mNavigationView.getHeaderView(0);
        TextView tvHeader = view.findViewById(R.id.tv_header);
        tvHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationViewActivity.this, "抢饭碗的", Toast.LENGTH_SHORT).show();
            }
        });
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.setting_menu:
                        Toast.makeText(NavigationViewActivity.this, "设置内容", Toast.LENGTH_SHORT).show();
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.about_menu:
                        Toast.makeText(NavigationViewActivity.this, "关于我们", Toast.LENGTH_SHORT).show();
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.clear_menu:
                        Toast.makeText(NavigationViewActivity.this, "清除缓存", Toast.LENGTH_SHORT).show();
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }
}
