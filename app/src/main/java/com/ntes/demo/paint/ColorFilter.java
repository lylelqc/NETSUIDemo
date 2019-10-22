package com.ntes.demo.paint;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * canvas滤镜效果
 */
public class ColorFilter extends View {
    public ColorFilter(Context context) {
        this(context, null);
    }

    public ColorFilter(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorFilter(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
