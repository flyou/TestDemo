package com.flyou.listview;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.AlarmClock;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyListView myListView=new MyListView(MainActivity.this);
        ArrayAdapter<String >adapter=new ArrayAdapter<String>(MainActivity.this,
        android.R.layout.simple_list_item_1,new String[]{"小明","小花","小红","小李","小刚","小龙","小飞","小虎","老王","小明","小花","小红","小李","小刚","小龙","小飞", "小虎", "老王"});
        myListView.setAdapter(adapter);
        setContentView(myListView);

    }


}
