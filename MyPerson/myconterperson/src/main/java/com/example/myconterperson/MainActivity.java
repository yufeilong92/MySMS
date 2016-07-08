package com.example.myconterperson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText et_photo;
    private EditText et_text;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_photo = (EditText) findViewById(R.id.et_photo);
        et_text = (EditText) findViewById(R.id.et_text);
        send = (Button) findViewById(R.id.Send);
        OnClickLstener();
    }

    private void OnClickLstener() {
        send.setOnClickListener(new View.OnClickListener() {

            private String text;
            private String photo;

            @Override
            public void onClick(View view) {
              //[☆]获取内容
               photo = et_photo.getText().toString().trim();
                text = et_text.getText().toString().trim();
               //[☆]获取smsmessger实例发送短信实例
                SmsManager smsManager = SmsManager.getDefault();

                ArrayList<String> strings = smsManager.divideMessage(text);
                for(String div:strings){

                smsManager.sendTextMessage(photo,null,div,null,null);
                }
            }
        });
    }

    public void SMS(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,SmsActivity.class);
        startActivityForResult(intent,2);

    }

    /**
     * 添加用户号码
      * @param v
     */
    public void add(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,ConterPerson.class);
//        startActivity(intent);
//        小细节 ，如果要开启的的activity需要结果使用startAtivityforResult
    //[☆]开启时使用这个并且要返回值
       startActivityForResult(intent,1);
    }

    /**当开启activity 页面关闭时调用这个方法
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//  请求码实现
        if(requestCode==1){
            String photo = data.getStringExtra("photo");
            et_photo.setText(photo);
        }else if(requestCode==2) {
            String result = data.getStringExtra("result");
            et_text.setText(result);
        }
    //[☆]j结果码实现
     /* if(resultCode==10){
       //[☆】返回点电话号码
        String photo = data.getStringExtra("photo");
        et_photo.setText(photo);
      }else if(resultCode==20){
        //[☆]返回短信模板
        String result = data.getStringExtra("result");
        et_text.setText(result);
      }*/
        super.onActivityResult(requestCode, resultCode, data);
    }
}
