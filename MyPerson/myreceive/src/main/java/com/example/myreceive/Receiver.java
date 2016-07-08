package com.example.myreceive;

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
        String name = intent.getStringExtra("name");
        Intent intent1 = new Intent();
        intent1.putExtra("name",intent1);
        setResultData(name);
        Toast.makeText(context ,"传过来的参数::"+name, Toast.LENGTH_SHORT).show();
    }
}
