package com.example.mylistreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//    发送有序广播
    public void click1(View v){
        //[☆]意图
        Intent intent = new Intent();
        intent.putExtra("name","新闻开始播了");
        //[☆]设置行动
        intent.setAction("com.zdwl.custom");
        //[☆]发送广播
        sendBroadcast(intent);
    }
    //    发送无序广播
    public void click(View v){
        Intent intent = new Intent();
        intent.setAction("com.zdwl.sendrice");

        /**
         * intent 意图
         *  receiverPermisson 就收权限
         *  resultReciver 最终的Receiver
         *  scheduler handler
         *  initalcode 初始码
         *  initialData初始化数据
         */
        sendOrderedBroadcast(intent,null,null,null,1,"习大大发1000斤大米",null);

    }
}
