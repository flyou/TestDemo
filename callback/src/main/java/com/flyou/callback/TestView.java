package com.flyou.callback;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * ============================================================
 * 项目名称：OrmListeDemo
 * 包名称：com.flyou.callback
 * 文件名：TestView
 * 类描述：
 * 创建人：flyou
 * 邮箱：fangjaylong@gmail.com
 * 创建时间：2015/9/15 9:48
 * 修改备注：
 * 版本：@version  V1.0
 * ============================================================
 */
public class TestView extends View {

private onTextClickListener mListener;
    /**
     * 文本
     */
    private String mTitleText="";
    /**
     * 文本的颜色
     */
    private int mTitleTextColor;
    /**
     * 文本的大小
     */
    public TestView(Context context) {
        this(context,null);

    }

    public TestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onTextClick();
            }
        });

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TestView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.measure(widthMeasureSpec,heightMeasureSpec);
//        上述方法最终还是调用的setMeasuredDimension（）这个方法，因此我们在这里直接调用这个方法，主要关注宽高的测量
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureHeight(int heightMeasureSpec) {
//        设置搞的默认值为0
        int result = 0;
//        获取测量模式
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
//        获取测量得到的高度
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
//     如果是精确模式就直接返回测量的高度 fillparemt 和固定的值都属于精确模式
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
//            如果模式为 AT_MOST 和UNSPECIFIED就需要指定一个默认值。warpContent属于和UNSPECIFIED模式
            result = 200;
            if (specMode == MeasureSpec.AT_MOST) {
//                如果是 AT_MOST模式就返回 默认值和返回测量值的最小值来作为最后的测量值
                result = Math.min(result, specSize);
            }


        }
        return result;
    }

    private int measureWidth(int widthMeasureSpec) {
    //        设置搞的默认值为0
        int result = 0;
//     获取测量模式
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
//     获取测量得到的宽度
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
//     如果是精确模式就直接返回测量的宽度
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
//     如果模式为 AT_MOST 和UNSPECIFIED就需要指定一个默认值。
            result = 200;
            if (specMode == MeasureSpec.AT_MOST) {
//     如果是 AT_MOST模式就返回 默认值和返回测量值的最小值来作为最后的测量值
                result = Math.min(result, specSize);
            }


        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("TestView", "onDraw");
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(20);
        canvas.drawText(mTitleText, 50, 100, paint);
        super.onDraw(canvas);
    }
    public  interface  onTextClickListener{

        public  void onTextClick();
    }


    public  void setOnTextClickLsitener(onTextClickListener listener){
        mListener=listener;

    }
    public void  setmTitleText(String text){
        this.mTitleText=text;
    }
}
