package com.example.ugre.startandroid.custom_components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.ugre.startandroid.R;

/**
 * Created by ugre9 on 20/01/2018.
 */

public class CustomImageView extends ImageView {

    Drawable icon;
    int[] drawables = {
            R.drawable.bombs_1, R.drawable.bombs_2, R.drawable.bombs_3,
            R.drawable.bombs_4, R.drawable.bombs_5
    };
    int value = 0;

    public CustomImageView(Context context) {
        super(context);
        init();
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init()
    {
        setWillNotDraw(false);
        icon = ContextCompat.getDrawable(getContext(), drawables[0]);
    }

    public void incBomb()
    {
       value = (value + 1) % 5;
       icon = ContextCompat.getDrawable(getContext(), drawables[value]);
       invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        icon.setBounds(0,0,getWidth(),getHeight());
        icon.draw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
