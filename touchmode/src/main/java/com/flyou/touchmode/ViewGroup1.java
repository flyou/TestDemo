package com.flyou.touchmode;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * ============================================================
 * 项目名称：OrmListeDemo
 * 包名称：com.flyou.touchmode
 * 文件名：ViewGroup1
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2015/9/16 14:51
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 */
public class ViewGroup1 extends LinearLayout {
    public ViewGroup1(Context context) {
        super(context);
    }

    public ViewGroup1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroup1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ViewGroup1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("ViewGroup1", "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);

    }

    @Override
        public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("ViewGroup1", "onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("ViewGroup1", "onTouchEvent");
        return super.onTouchEvent(event);
    }
}
