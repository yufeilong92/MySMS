package com.example.dialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "输出结果";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 点击一个按钮弹出一个对话框
     *
     * @param v
     */
    public void click(View v) {
        //[☆]通过builder构建器来构造
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("警告");
        builder.setMessage("世界上最遥远的距离是没有网络");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i(TAG, "onClick: 你点击了确定按钮");
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i(TAG, "onClick: 你点击了取消按钮");
            }
        });
        //[☆]最好一定要show显示
        builder.show();
    }

    /**
     * 弹出一个单项对话框
     */

    public void click1(View v) {
        final String[] items = {"android", "ios", "c", "C++", "html", "C#"};
        //[☆]通过builder构建器来构造
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择你喜欢的课程");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //[☆]把选中的条目的取出来
                //[☆]数据在哪里存到哪里取
                String item = items[i];
                Toast.makeText(getApplicationContext(), "你选中" + item, Toast.LENGTH_SHORT).show();
                //[☆]把对话框关闭
                dialogInterface.dismiss();
            }
        });

        //[☆]最好一定要show显示
        builder.show();
    }

    /**
     *弹出一个对选对话框
     * @param v
     */
    public void click2(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("喜欢一下水果吗？");
        final String[] item = {"西瓜", "哈密瓜", "香蕉", "葡萄", "黄瓜", "苹果", "柚子"};
        final boolean[] checkedItems = {true, false, false, false, false, false, false,};
        builder.setMultiChoiceItems(item, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int positon) {
                //[☆]把选中的数据取出来
                //[☆]把取出的缓存到sp
                StringBuffer sp = new StringBuffer();
                for (int i = 0; i < item.length; i++) {
                    if (checkedItems[i]) {
                        String s = item[i];
                        //[☆]显示
                        sp.append(s + "");
                    }
                }
                Toast.makeText(getApplicationContext(), "取出数据" + sp.toString(), Toast.LENGTH_SHORT).show();
                //[☆]关闭对话框
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    /**
     * 点击一个按钮是弹出一个进度条对话框
     * @param v
     */
   public void click3(View v){
       final ProgressDialog dialog = new ProgressDialog(this);
       dialog.setTitle("正在玩命加载中");
      //[☆]设置进度条样式
       dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

       dialog.show();
//       跟新进度要在子线程更新
       new Thread(new Runnable() {
           @Override
           public void run() {
              //[☆]设置进度条的最大值
               dialog.setMax(100);
               //[☆]设置当前进度
               for (int i = 0; i <=100 ; i++) {
                   dialog.setProgress(i);
//      这个方法会报异常     Thread.sleep(200);
                  //[☆]这个不会
                   SystemClock.sleep(50);
               }
               //[☆]关闭对话框
               dialog.dismiss();
           }
       }).start();
   }

}
