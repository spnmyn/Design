package com.example.administrator.design.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.design.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnCLick(View view) {
        switch (view.getId()) {
            case R.id.btn_TextInputLayout:
                startActivity(new Intent(MainActivity.this, TextInputLayoutActivity.class));
                break;
            case R.id.btn_FloatingActionButton:
                startActivity(new Intent(MainActivity.this, FloatingActionButtonActivity.class));
                break;
            case R.id.btn_SnackBar:
                startActivity(new Intent(MainActivity.this, SnackBarActivity.class));
                break;
            case R.id.btn_NavigationView:
                startActivity(new Intent(MainActivity.this, NavigationViewActivity.class));
                break;
            case R.id.btn_TabLayout:
                startActivity(new Intent(MainActivity.this, TabLayoutActivity.class));
                break;
            case R.id.btn_ToolBar:
                startActivity(new Intent(MainActivity.this, ToolBarActivity.class));
                break;
            case R.id.btn_NestedScroll:
                startActivity(new Intent(MainActivity.this, NestedScrollActivity.class));
                break;
            case R.id.btn_ToolBarNestedScroll:
                startActivity(new Intent(MainActivity.this, ToolBarNestedScrollActivity.class));
                break;
            case R.id.btn_CollapsingToolLayout:
                startActivity(new Intent(MainActivity.this, CollapsingToolLayoutActivity.class));
                break;
            case R.id.btn_BottomSheet:
                startActivity(new Intent(MainActivity.this, BottomSheetActivity.class));
                break;
            case R.id.btn_Notification:
                startActivity(new Intent(MainActivity.this, Notification.class));
                break;
            default:
                break;
        }
    }
}
