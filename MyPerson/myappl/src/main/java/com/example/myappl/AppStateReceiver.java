package com.example.myappl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/7/7.
 */
public class AppStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals("android.intent.action.PACKAGE_INSTALL")){
            Loges.i("应用","应用安装1111");
        }else if(action.equals("android.intent.action.PACKAGE_ADDED")){
            Loges.i("应用","应用安装2222");
        }else if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
            Loges.i("应用","应用卸载3333"+intent.getData());
        }
    }
}
