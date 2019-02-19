package com.example.zohar.androiddeepbok.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zohar.androiddeepbok.R;
import com.example.zohar.androiddeepbok.utils.DensityUtils;

/**
 * Created by lhZou on 2019/02/19.
 * desc:
 */
public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;     //分割线Drawable
    private int mDividerHeight;  //分割线高度（dp）

    /**
     * 使用line_divider中定义好的颜色
     *
     * @param context         上下文
     * @param dividerHeightDp 分割线高度（dp）
     */
    public SimpleDividerItemDecoration(Context context, int dividerHeightDp) {
        mDivider = ContextCompat.getDrawable(context, R.drawable.line_divider);
        mDividerHeight = dividerHeightDp;
    }

    /**
     * @param context         上下文
     * @param divider         分割线Drawable
     * @param dividerHeightDp 分割线高度（dp）
     */
    public SimpleDividerItemDecoration(Context context, Drawable divider, int dividerHeightDp) {
        if (divider == null) {
            mDivider = ContextCompat.getDrawable(context, R.drawable.line_divider);
        } else {
            mDivider = divider;
        }
        mDividerHeight = DensityUtils.dp2px(context, dividerHeightDp);
    }

    //获取分割线尺寸
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0, 0, 0, mDividerHeight);
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDividerHeight;
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
}