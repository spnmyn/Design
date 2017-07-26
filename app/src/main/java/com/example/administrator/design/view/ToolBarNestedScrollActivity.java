package com.example.administrator.design.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.administrator.design.R;

public class ToolBarNestedScrollActivity extends AppCompatActivity {
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_nested_scroll);
        mToolBar = ((Toolbar) findViewById(R.id.toolBar));
        setSupportActionBar(mToolBar);
    }
}
