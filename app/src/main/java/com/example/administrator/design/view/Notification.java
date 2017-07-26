package com.example.administrator.design.view;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.RemoteViews;

import com.example.administrator.design.R;

public class Notification extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    public void onClick(View v) {
        // 创建通知构建器
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        switch (v.getId()) {
            case R.id.common:
                // 必选，小图标、标题、内容
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("标题 凤姐来了");
                builder.setContentText("内容 凤姐请你吃饭了！");
                // 可选
                builder.setTicker("凤姐通知来了！");
                builder.setContentInfo("附加信息");
                // 大图标
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.fengjie);
                builder.setLargeIcon(icon);
                // 发送时间
                builder.setWhen(System.currentTimeMillis());
                // 点击通知，页面跳转
                Intent intent = new Intent(Notification.this, NotificationNext.class);
                intent.putExtra("msg", "凤姐爱你！");
                /*
                * PendingIntent,延迟意图,当某个条件触发，会启动内部意图
                * FLAG_ONE_SHOT,延迟意图只执行一次，之后取消
                * FLAG_NO_CREATE,延迟意图如果不存在，不创建，返回null
                * FLAG_CANCEL_CURRENT,延迟意图如果存在，取消该意图，创建新的延迟意图
                * FLAG_UPDATE_CURRENT,更新当前意图
                * */
                PendingIntent pIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pIntent);
                // 设置通知的铃声
                builder.setSound(Uri.parse("file:///sdcard/Notifications/escape.mp3"));
                // 多媒体库中的铃声
                //builder.setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "5"));
                /*
                * 设置震动
                * 第一次震动需要等待的时长，从发送通知开始计算
                * 第一次震动的时长,后续参数依次类推
                * */
                builder.setVibrate(new long[]{0, 100, 200, 300});
                /*
                * 设置闪关灯
                * 闪关灯闪烁的颜色
                * onMs,持续的毫秒数
                * offMs,停顿的毫秒数
                * */
                builder.setLights(0xff0000ff, 300, 300);
                // <uses-permission android:name="android.permission.VIBRATE"/>
                // <uses-permission android:name="android.permission.FLASHLIGHT"/>
                // 设置默认的三种情况
                // builder.setDefaults(Notification.DEFAULT_ALL);
                // 创建通知管理器,需要使用系统服务
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                /*
                * 发送通知
                * 参数1 应用中为通知设置的唯一的标记
                * 参数2 发送的通知
                * */
                manager.notify(1, builder.build());
                break;
            case R.id.bigText:
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("BigText");
                builder.setContentText("BigText");
                // 创建BitText样式
                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                bigTextStyle.setBigContentTitle("大文本标题");
                bigTextStyle.setSummaryText("摘要");
                bigTextStyle.bigText("这文本内容，此处有好几十万字，但是都省略了......");
                // 给通知构建器设置BigText样式
                builder.setStyle(bigTextStyle);
                manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(2, builder.build());
                break;
            case R.id.bigPicture:
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("BigPicture");
                builder.setContentText("BigPicture");
                // 创建BigPicture样式
                NotificationCompat.BigPictureStyle bigPicStyle = new NotificationCompat.BigPictureStyle();
                Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.fengjie);
                bigPicStyle.bigPicture(bm);
                // 给通知构建器设置BigPicture样式
                builder.setStyle(bigPicStyle);
                manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(3, builder.build());
                break;
            case R.id.inBox:
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("InBox");
                builder.setContentText("InBox");
                // 创建InBox样式
                NotificationCompat.InboxStyle inBoxStyle = new NotificationCompat.InboxStyle();
                for (int i = 0; i < 5; i++) {
                    inBoxStyle.addLine("大海啊！全是水！");
                }
                builder.setStyle(inBoxStyle);
                manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(4, builder.build());
                break;
            case R.id.progressBar:
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("进度条通知");
                builder.setContentText("进度条通知");
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                final NotificationManager managerProgressBar = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                // 启动子线程，更新进度
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        for (int i = 0; i <= 100; i++) {
                            /*
                            * max 最大的进度值
                            * progress 更新进度的值
                            * indeterminate 不确定的，模糊的，精确进度条为false
                            * */
                            builder.setProgress(100, i, false);
                            // 每次更新进度，发送通知
                            managerProgressBar.notify(5, builder.build());
                            try {
                                Thread.sleep((int) (Math.random() * 100));
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                        // 下载完成
                        builder.setProgress(0, 0, false);
                        builder.setContentText("下载完成");
                        managerProgressBar.notify(5, builder.build());
                    }
                }).start();
                break;
            case R.id.selfStyle:
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("自定义通知");
                builder.setContentText("自定义通知");
                intent = new Intent();
                intent.setClass(this, NotificationNext.class);
                intent.putExtra("msg", "自定义通知");
                pIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT);
                /*
                * 创建view
                * 参数一 包名
                * 参数二 布局文件
                * */
                RemoteViews views = new RemoteViews(getPackageName(), R.layout.notification_self_style);
                /*
                * 点击某个控件触发事件
                * viewId，触发事件的控件的id。延迟意图
                * */
                views.setOnClickPendingIntent(R.id.play, pIntent);
                builder.setContent(views);
                manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(6, builder.build());
                break;
        }
    }
}
