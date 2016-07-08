package com.example.mysmslistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

/**
 * Created by Administrator on 2016/7/7.
 */
public class SMSlistenerReceiver extends BroadcastReceiver {
    //[☆]当短信到来时候z执行
    @Override
    public void onReceive(Context context, Intent intent) {
        Loges.i("短信到来", "哈哈哈");
        Object[] pdus = (Object[]) intent.getExtras().get("pdus");
        for (Object obj:pdus) {
            //获取smsmessagede实例
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) obj);
            //[☆]、获取发信的内容
            String messageBody = smsMessage.getMessageBody();
            //[☆]获取原始的地址（发送者）
            String address = smsMessage.getOriginatingAddress();

        }
    }
}
