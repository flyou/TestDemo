package com.flyou.ormlistedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flyou.ormlistedemo.db.domain.DatabaseHelper;
import com.flyou.ormlistedemo.db.domain.User;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    Button button2;
    Button button3;
    Button button4;
    User user;
    Dao<User, Integer> userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }


    private void initView() {
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        user = new User("flyou1", "文艺少年");
        try {
            userDao = DatabaseHelper.getHelper(MainActivity.this).getUserDao();
            userDao.create(user);
            user = new User("flyou2", "文艺少年");
            userDao.create(user);
            user = new User("flyou3", "文艺少年");
            userDao.create(user);
            user = new User("flyou4", "文艺少年");
            userDao.create(user);
            user = new User("flyou5", "文艺少年");
            userDao.create(user);
            user = new User("flyou6", "文艺少年");
            userDao.create(user);
            user = new User("flyou7", "文艺少年");
            userDao.create(user);
            user = new User("flyou8", "文艺少年");
            userDao.create(user);
            user = new User("flyou9", "文艺少年");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button:
                user = new User("房泽龙", "哈哈哈哈哈哈");
                try {
                    userDao.create(user);
                    query();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button2:
                try {
                    userDao.deleteById(2);
                    query();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button3:
                try {
                   user=new User("周杰伦","哈哈哈哈");
                    user.setId(5);
                    userDao.update(user);
                    query();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break; case R.id.button4:
                query();
                break;
        }
    }
    public  void  query(){

        try {
            List<User> users = userDao.queryForAll();
            Log.d("MainActivity", "users.toArray():" + users.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
