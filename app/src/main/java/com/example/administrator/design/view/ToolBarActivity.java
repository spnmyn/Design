package com.example.administrator.design.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.administrator.design.R;

public class ToolBarActivity extends AppCompatActivity {
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        mToolBar = ((Toolbar) findViewById(R.id.toolBar));
        // 设置导航图标
        mToolBar.setNavigationIcon(R.drawable.dog);
        // 设置LOGO
        mToolBar.setLogo(R.mipmap.ic_launcher);
        // 设置标题
        mToolBar.setTitle("我是ToolBarTitle");
        // 设置子标题
        mToolBar.setSubtitle("我是SunTitle");
        // 设置ActionBar
        setSupportActionBar(mToolBar);
    }
}
