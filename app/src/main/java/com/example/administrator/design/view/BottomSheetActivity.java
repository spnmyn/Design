package com.example.administrator.design.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.design.R;
import com.example.administrator.design.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/*
* STATE_COLLAPSED 关闭BottomSheet,显示高度为PeekHeight，默认是0
* STATE_DRAGGING 用户拖拽BottomSheet时状态
* STATE_SETTLING BottomSheetsView释放时记录状态
* STATE_EXPANDED BottomSheet展开状态
* STATE_HIDDEN BottomSheet隐藏状态
* */
public class BottomSheetActivity extends Activity implements View.OnClickListener {
    /*声明控件*/
    private Button buttonPopText;
    private Button buttonPopRecyclerView;
    private RecyclerView recyclerView;
    private CoordinatorLayout coordinatorLayout;
    /*声明Behavior*/
    private BottomSheetBehavior behavior;
    /*声明数据集合*/
    private List<String> data;
    /*声明适配器*/
    private MyAdapter myAdapter;
    /*声明线性布局管理器*/
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        // 初始化控件方法
        initView();
        // 给控件添加点击监听方法
        setListener();
        // 初始化变量方法
        initVariable();
        // 初始化数据方法
        initData();
    }

    /**
     * @decs: 初始化数据
     * @author: 郑少鹏
     * @date: 2017/7/24 15:17
     * @param:
     * @return:
     * @version: v 1.0
     */
    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("item" + i);
        }
    }

    /**
     * @decs: 初始化变量
     * @author: 郑少鹏
     * @date: 2017/7/23 16:34
     * @param:
     * @return:
     * @version: v 1.0
     */
    private void initVariable() {
        behavior = BottomSheetBehavior.from(findViewById(R.id.nestedScrollView));
        // 设置关闭时显示高度
        behavior.setPeekHeight(20);
        // 使用隐藏功能时，需提前设置
        behavior.setHideable(true);
    }

    /**
     * @decs: 给控件添加点击监听
     * @author: 郑少鹏
     * @date: 2017/7/23 16:31
     * @param:
     * @return:
     * @version: v 1.0
     */
    private void setListener() {
        buttonPopText.setOnClickListener(this);
        buttonPopRecyclerView.setOnClickListener(this);
    }

    /**
     * @decs: 初始化控件
     * @author: 郑少鹏
     * @date: 2017/7/23 16:30
     * @param:
     * @return:
     * @version: v 1.0
     */
    private void initView() {
        buttonPopText = findViewById(R.id.buttonPopText);
        buttonPopRecyclerView = findViewById(R.id.buttonPopRecyclerView);
        recyclerView = findViewById(R.id.recyclerView);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonPopText:// 文字示例
                if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                break;
            case R.id.buttonPopRecyclerView:// RecyclerView示例
                // 解除父布局与子布局关系
                ViewGroup parent = (ViewGroup) recyclerView.getParent();
                if (parent != null) {
                    parent.removeView(recyclerView);
                }
                // 创建并设置布局管理器
                mLinearLayoutManager = new LinearLayoutManager(this);
                mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(mLinearLayoutManager);
                myAdapter = new MyAdapter(BottomSheetActivity.this, data);
                recyclerView.setAdapter(myAdapter);
                // 创建BottomSheetDialog并设置内容布局
                BottomSheetDialog dialog = new BottomSheetDialog(this);
                dialog.setContentView(recyclerView);
                dialog.show();
                break;
            default:
                break;
        }
    }
}
