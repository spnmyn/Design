package com.example.administrator.design.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.design.R;
import com.example.administrator.design.adapter.MyFragmentPagerAdapter;
import com.example.administrator.design.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragment;
    private List<String> mTitles;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        initView();
        initData();
    }

    private void initData() {
        mFragment = new ArrayList<>();
        mTitles = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            mFragment.add(new MyFragment());
            mTitles.add("标题" + i);
        }
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragment, mTitles);
        mViewPager.setAdapter(myFragmentPagerAdapter);
        // TabLayout和ViewPager进行关联
        mTabLayout.setupWithViewPager(mViewPager);
        /*
        * app:tabMode="fixed"在布局中设置模式
        * fixed 平分屏幕
        * SCROLLABLE 屏幕能展示多少,就先展示多少,其余滑动进入
        * */
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void initView() {
        mTabLayout = ((TabLayout) findViewById(R.id.tabLayout));
        mViewPager = ((ViewPager) findViewById(R.id.viewPager));
    }
}
