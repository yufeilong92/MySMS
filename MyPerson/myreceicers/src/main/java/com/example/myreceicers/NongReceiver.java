package com.example.myreceicers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/7.
 */
public class NongReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String resultData = getResultData();
        Toast.makeText(context ,"农"+resultData, Toast.LENGTH_SHORT).show();

    }
}
