package com.example.myappdrwablenim;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView rockeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //[☆]找到控件，显示动画
        rockeImage = (ImageView) findViewById(R.id.lv);

       //[☆]设置背景资源
        rockeImage.setBackgroundResource(R.drawable.mylist);
        //[☆]兼容性低版本写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(50);
                //[☆]获取rocketAnimation 类型
                AnimationDrawable rocketAnimation = (AnimationDrawable) rockeImage.getBackground();
                //[☆]开启动画
                rocketAnimation.start();
            }
        }).start();
    }
}
