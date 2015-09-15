package com.flyou.ormlistedemo.db.domain;

import android.content.Context;
import android.nfc.tech.IsoDep;

import com.j256.ormlite.field.DatabaseField;

import java.sql.SQLException;

/**
 * ============================================================
 * 项目名称：OrmListeDemo
 * 包名称：com.flyou.ormlistedemo.db.domain
 * 文件名：UserDao
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2015/9/11 11:11
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 */
public class UserDao
{
    private Context context;

    public UserDao(Context context)
    {
        this.context = context;
    }
//插入数据
    public void add(User user)
    {
        try
        {
            DatabaseHelper.getHelper(context).getUserDao().create(user);
        } catch (SQLException e)
        {
        }
    }
    public  void deleteById(int id){

        try {
            DatabaseHelper.getHelper(context).getUserDao().deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
