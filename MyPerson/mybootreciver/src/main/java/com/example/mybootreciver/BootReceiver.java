package com.example.mybootreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/7/7.
 */
public class BootReceiver extends BroadcastReceiver {
    /***
     * 当手机重新启动
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent();
        intent1.setClass(context,MainActivity.class);
//        不能广播接收者里面开启activity ,需要添加一个标记，添加一个任务栈
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
