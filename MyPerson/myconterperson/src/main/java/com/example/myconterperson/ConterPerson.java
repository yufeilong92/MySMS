package com.example.myconterperson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class ConterPerson extends Activity {


    private ListView lv;
    private List<Person> list=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_activity);
        lv = (ListView) findViewById(R.id.person_list);
        list=new ArrayList<Person>();
        initData();
        MyAdaper myAdaper = new MyAdaper();
        lv.setAdapter(myAdaper);
        OnItemClickListener();
    }

    private void OnItemClickListener() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
//                    (listvew  , item ,点击的下标，点击的id)
            public void onItemClick(AdapterView<?> adapterView, View view, int positon, long id) {
                String photo = list.get(positon).getPhoto();
              //[☆]数据传过来
                Intent intent = new Intent();
                intent.putExtra("photo",photo);
                //[☆]把结果返回给调用者
                setResult(10,intent);

                //[☆]关闭当前页面
                finish();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initData() {
        for (int i = 0; i <20 ; i++) {
            Person person = new Person();
            person.setName("飞龙"+i);
            person.setPhoto("1831783756"+i);
            list.add(person);
        }
    }
    public class MyAdaper extends BaseAdapter{

        private TextView name;
        private TextView photo;

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int postion, View converView, ViewGroup viewGroup) {
          View view=null;
           if(converView==null){
               view=View.inflate(getApplicationContext(), R.layout.person_item,null);
           }else {
               view=converView;
           }
            name = (TextView) view.findViewById(R.id.person_item_name);
            photo = (TextView) view.findViewById(R.id.person_item_photo);
            name.setText(list.get(postion).getName());
            photo.setText(list.get(postion).getPhoto());
            return view;
        }
    }
}
