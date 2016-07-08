package com.example.myactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/7/7.
 */
public class MainActivity1  extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
    }
    public void open2(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity1.this,MainActivity.class);
        startActivity(intent);
    }
    public void Open3(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity1.this,Mainactivity2.class);
        startActivity(intent);
    }
}
