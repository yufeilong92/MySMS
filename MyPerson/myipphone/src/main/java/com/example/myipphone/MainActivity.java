package com.example.myipphone;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_ip = (EditText) findViewById(R.id.et_ip);
    }

    public void save(View v) {
        //[☆]获取用户的输入的ip保存sp
        String trim = et_ip.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            Toast.makeText(getApplicationContext(), "请输入IP", Toast.LENGTH_SHORT).show();
            return;
        }else {
        //[☆]把当前的ipnimber存起来，存在sp里面
        SharedPreferences sp = getSharedPreferences("config", 0);
        //[☆]获取sp的编译器
        SharedPreferences.Editor edit = sp.edit();
        //[☆]储存内容
        SharedPreferences.Editor trim1 = edit.putString("trim", trim);
        //[☆]提交 储存
        trim1.commit();
        Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
        finish();}

    }
}
