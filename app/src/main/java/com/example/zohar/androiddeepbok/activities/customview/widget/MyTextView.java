package com.example.zohar.androiddeepbok.activities.customview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.zohar.androiddeepbok.R;
import com.example.zohar.androiddeepbok.utils.LogUtils;

public class MyTextView extends View {
    private final String TAG = "MyTextView";
    private final int paddingLeft = 8;
    private final int paddingTop = 8;
    private final int paddingRight = 8;
    private final int paddingBottom = 8;

    private String mText;//文字内容
    private float mTextSize;//文字大小
    private int mTextColor;//文字颜色

    private Rect mBound;
    private Paint mPaint;

    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化
        //获取自定义属性的值
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyTextView, defStyleAttr, 0);
        mText = a.getString(R.styleable.MyTextView_mText);
        mTextSize = a.getDimension(R.styleable.MyTextView_mTextSize, 100);
        mTextColor = a.getColor(R.styleable.MyTextView_mTextColor, Color.BLACK);
        a.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(mTextColor);

        //获得绘制文本的宽高
        mBound = new Rect();
        mPaint.getTextBounds(mText, 0, mText.length(), mBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);//获取宽的模式
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);//获取高的模式
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);//获取宽的尺寸
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);//获取高的尺寸
        LogUtils.v(TAG, "---------------- ".concat(mText).concat(" ----------------"));
        LogUtils.v(TAG, "宽的模式:" + widthMode);
        LogUtils.v(TAG, "高的模式:" + heightMode);
        LogUtils.v(TAG, "宽的尺寸:" + widthSize);
        LogUtils.v(TAG, "高的尺寸:" + heightSize);

        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            float textWidth = mBound.width();
            width = (int) (paddingLeft + textWidth + paddingRight);
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            float textHeight = mBound.height();
            height = (int) (paddingTop + textHeight + paddingBottom);
        }

        //保存测量的宽高值
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制文字
        canvas.drawText(mText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);
    }
}
