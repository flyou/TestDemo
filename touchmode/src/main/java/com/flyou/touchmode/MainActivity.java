package com.flyou.touchmode;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view =new View(MainActivity.this);
        view.setBackgroundColor(Color.RED);
        ViewGroup2 viewGroup2=new ViewGroup2(MainActivity.this);
        viewGroup2.setBackgroundColor(Color.BLUE);
        viewGroup2.addView(view, 200, 200);

        ViewGroup1 viewGroup1=new ViewGroup1(MainActivity.this);
        viewGroup1.setBackgroundColor(Color.GREEN);
        viewGroup1.addView(viewGroup2, 350, 350);
        setContentView(viewGroup1);
    }


}
