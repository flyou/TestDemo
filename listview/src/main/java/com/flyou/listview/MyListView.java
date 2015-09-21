package com.flyou.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

/**
 * ============================================================
 * 项目名称：OrmListeDemo
 * 包名称：com.flyou.listview
 * 文件名：MyListView
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2015/9/17 8:56
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 */
public class MyListView extends ListView {
    int mMaxOverDistance=50;
    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public MyListView(Context context) {
        this(context,null);
    }

    public MyListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxOverDistance, isTouchEvent);
    }
    public  void  initView(Context context){

        DisplayMetrics metrics=context.getResources().getDisplayMetrics();
        float density=metrics.density;
        mMaxOverDistance=(int)(density*mMaxOverDistance);
    }
}
