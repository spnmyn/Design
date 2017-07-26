package com.example.administrator.design.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.administrator.design.R;

public class CollapsingToolLayoutActivity extends AppCompatActivity {
    /*声明控件*/
    private Toolbar mToolBar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_tool_layout);
        // 初始化控件
        mToolBar = ((Toolbar) findViewById(R.id.toolBar));
        mCollapsingToolbarLayout = ((CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout));
        setSupportActionBar(mToolBar);
        // 设置展开时ActionBar标题颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.GREEN);
        // 设置折叠时ActionBar标题颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLUE);
    }
}
