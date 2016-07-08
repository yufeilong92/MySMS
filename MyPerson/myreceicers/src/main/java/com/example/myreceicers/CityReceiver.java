package com.example.myreceicers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/7.
 */
public class CityReceiver  extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String resultData = getResultData();
        Toast.makeText(context ,"市"+resultData, Toast.LENGTH_SHORT).show();
     //[☆]终止广播
        abortBroadcast();
      //[☆]修改数据
//        setResultData("习大大给每个村民发了200斤");
    }
}
