package com.example.administrator.design.view;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.design.R;

public class NotificationNext extends Activity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_next);
        textView = findViewById(R.id.tv_next);
        // 获取Intent
        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        textView.setText(msg);
        // 获取通知管理器
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        /*
        * 取消指定id的通知 manager.cancel(id);
        * 取消所有通知 manager.cancelAll();
        * */
        manager.cancelAll();
    }
}
