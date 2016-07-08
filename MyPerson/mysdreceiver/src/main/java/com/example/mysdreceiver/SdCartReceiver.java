package com.example.mysdreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/7/7.
 */
public class SdCartReceiver extends BroadcastReceiver {
    /**
     * 当SD卡状态发生改变时执行
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
            //[☆]获取广播事件类型
        String action = intent.getAction();
        if(action.equals("android.intent.action.MEDIA_MOUNTED")){
          Loges.i("SD挂载","SD存在");
        }else if(action.equals("android.intent.action.MEDIA_UNMOUNTABLE")){
            Loges.i("SD挂载","卸载了");
        }
    }
}
