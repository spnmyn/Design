package com.example.administrator.design.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.design.R;
import com.example.administrator.design.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class FloatingActionButtonActivity extends Activity {
    private RecyclerView mRecyclerView;
    private List<String> data;
    private MyAdapter myAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);
        // 初始化控件
        mRecyclerView = findViewById(R.id.rv_float_show);
        initData();
        setData();
    }

    /**
     * @decs: 设置数据
     * @author: 郑少鹏
     * @date: 2017/7/24 10:31
     * @param:
     * @return:
     * @version: v 1.0
     */
    private void setData() {
        // 创建并设置布局管理器
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        myAdapter = new MyAdapter(FloatingActionButtonActivity.this, data);
        mRecyclerView.setAdapter(myAdapter);
    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("item" + i);
        }
    }

    public void onCLick(View view) {
        if (view != null) {
            // 滑动到顶部
            mRecyclerView.scrollToPosition(0);
        }
    }
}
