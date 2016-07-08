package com.example.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Loges.i("生命周期","onCreate");
    }


    @Override
    protected void onStart() {
        Loges.i("生命周期","onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Loges.i("生命周期","onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Loges.i("生命周期","onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Loges.i("生命周期","onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Loges.i("生命周期","onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Loges.i("生命周期","onDestroy");
        super.onDestroy();
    }
}
