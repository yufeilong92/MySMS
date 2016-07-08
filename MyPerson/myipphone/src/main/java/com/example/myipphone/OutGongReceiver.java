package com.example.myipphone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/7/7.
 */
public class OutGongReceiver  extends BroadcastReceiver{
    /**
     * 当进行外拨电话时候调用
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
    //[☆]获取当前的拨打电话号码
       //[☆]获取用户保存的号码,Comfig.xml里面保存
        SharedPreferences sp = context.getSharedPreferences("config", 0);
        //[☆]获取保存的文件获取ip号码
        String trim = sp.getString("trim", "");


        String resultData = getResultData();
        Loges.i("拨打的电话",resultData);

        //[☆]在当期的号码前面加上17951
        if(resultData.startsWith("0")){
        setResultData(trim+resultData);
            Loges.i("拨打的电话",trim+resultData);

        }
    }
}

