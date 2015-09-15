package com.flyou.callback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private  TestView testView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testView= (TestView) findViewById(R.id.text);
        testView.setmTitleText("哈哈哈哈哈哈");
        testView.setOnTextClickLsitener(new TestView.onTextClickListener() {
            @Override
            public void onTextClick() {
                Toast.makeText(MainActivity.this, "我被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
