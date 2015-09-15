package com.flyou.simplebaseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private List<String> dates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();
        initView();

    }

    private void initDate() {
        dates = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dates.add("我是数据" + i);

        }
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.listview);
        ListAdapter adapter=new ListAdapter(MainActivity.this,dates);
        mListView.setAdapter(adapter);
    }


}
