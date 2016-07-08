package com.example.myreceicers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/7.
 */
public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String resultData = getResultData();
         Toast.makeText(context ,"省"+resultData, Toast.LENGTH_SHORT).show();
        setResultData("习大大发了500斤");


    }
}
