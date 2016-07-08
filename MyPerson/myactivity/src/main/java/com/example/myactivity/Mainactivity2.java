package com.example.myactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/7/7.
 */
public class Mainactivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
    public void open5(View v){
        Intent intent = new Intent();
        intent.setClass(Mainactivity2.this,MainActivity1.class);
        startActivity(intent);
    }
    public void Open4(View v){
        Intent intent = new Intent();
        intent.setClass(Mainactivity2.this,MainActivity.class);
        startActivity(intent);
    }
}
