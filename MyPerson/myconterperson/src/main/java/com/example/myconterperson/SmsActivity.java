package com.example.myconterperson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/7/6.
 */
public class SmsActivity extends Activity {

    private ListView sms_list;
    //    private List<SMS> list=null;
    String object[] = {"我在吃饭，请稍后联系", "我在上班，请稍后联系", "我在开会，请稍后联系", "我在打lol，请稍后联系"
            , "我现在有事，请稍后联系", "我准备睡觉，请稍后联系", "我在学习，请稍后联系", "我在学习，请稍后联系"
            , "我在逛街，请稍后联系", "我在开车，请稍后联系", "我在打电话，请稍后联系", "我在听歌，请稍后联系"};
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms_activity);
        sms_list = (ListView) findViewById(R.id.sms_list);
//        list=new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(), R.layout.sms_item, R.id.sms_text, object);
//        initData();
//        MyAdapter myAdapter = new MyAdapter();

        sms_list.setAdapter(arrayAdapter);
        OnItemClickListener();
    }


    private void OnItemClickListener() {
        sms_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//               [☆]获取内容
                String sms = object[i];
//               [☆]创建意图
                Intent intent = new Intent();
//                [☆]发送
                intent.putExtra("result", sms);
//                [☆]调用setRsult给调用则返回结果
                setResult(20, intent);
//               [☆]关闭activity
                finish();
            }
        });
    }


//    private void initData() {
//        SMS sms = new SMS();
//        sms.setResult("我在吃饭，请稍后联系");
//        list.add(sms);
//        sms.setResult("我在上班，请稍后联系");
//        list.add(sms);
//        sms.setResult("我在开会，请稍后联系");
//        list.add(sms);
//        sms.setResult("我在打lol，请稍后联系");
//        list.add(sms);
//        sms.setResult("我现在有事，请稍后联系");
//        list.add(sms);
//        sms.setResult("我准备睡觉，请稍后联系");
//        list.add(sms);
//        sms.setResult("我在学习，请稍后联系");
//        list.add(sms);
//        sms.setResult("我在逛街，请稍后联系");
//        list.add(sms);
//        sms.setResult("我在开车，请稍后联系");
//        list.add(sms);
//        sms.setResult("我在打电话，请稍后联系");
//        list.add(sms);
//        sms.setResult("我在听歌，请稍后联系");
//        list.add(sms);
//
//
//        list.add(sms);


}
//    public class MyAdapter extends BaseAdapter{
//
//        private TextView sms_text;
//
//        @Override
//        public int getCount() {
//            return list.size();
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int positon, View converView, ViewGroup viewGroup) {
//           View view=null;
//            if(converView==null){
//           view=View.inflate(getApplicationContext(), R.layout.sms_item,null);
//           }else {
//                view=converView;
//            }
//            sms_text = (TextView) view.findViewById(R.id.sms_text);
//            sms_text.setText(list.get(positon).getResult());
//            return view;
//        }
//    }

//}
