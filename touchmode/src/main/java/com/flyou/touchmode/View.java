package com.flyou.touchmode;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * ============================================================
 * 项目名称：OrmListeDemo
 * 包名称：com.flyou.touchmode
 * 文件名：View
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2015/9/16 14:55
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 */
public class View  extends android.view.View{
    public View(Context context) {
        super(context);
    }

    public View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public View(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("View", "dispatchTouchEvent");
return  true;
//   return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("View", "onTouchEvent");
        return super.onTouchEvent(event);
    }
}
