package com.ntes.demo.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ntes.demo.R;

/**
 * paint使用和渲染
 */
public class GridientLayout extends View {

    private Paint paint;
    private Bitmap mBitmap;

    public GridientLayout(Context context) {
        super(context);
        init();
    }

    public GridientLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GridientLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 线性渲染
//        Shader gradient = new LinearGradient(0, 0, 500, 500, new int[]{Color.BLUE,Color.GREEN, Color.RED},
//                new float[]{0f, 0.7f, 1}, Shader.TileMode.REPEAT);
//        paint.setShader(gradient);
//        canvas.drawCircle(500,500,500, paint);

        // 环形渲染
//        Shader gradient = new RadialGradient(250, 250, 250, new int[]{Color.BLUE,Color.GREEN, Color.RED},
//                new float[]{0f, 0.7f, 1}, Shader.TileMode.CLAMP);
//        paint.setShader(gradient);
//        canvas.drawCircle(250,250,250, paint);

        // 扫描渲染
//        Shader gradient = new SweepGradient(250, 250, Color.BLUE, Color.RED);
//        paint.setShader(gradient);
//        canvas.drawCircle(250,250,250, paint);

        // 位图渲染
//        Shader gradient = new BitmapShader(mBitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
//        paint.setShader(gradient);
//        // CLAMP 绘制区域超过渲染区域的部分，最后一个像素的拉伸排版
        // REPEAT 绘制区域超过渲染区域的部分，重复排版
        // MIRROR 绘制区域超过渲染区域的部分，镜像翻转排版
//        canvas.drawRect(0,0, 500, 500, paint);

        // 组合渲染
        Shader gradient = new ComposeShader(null, null, PorterDuff.Mode.MULTIPLY);
        paint.setShader(gradient);
        canvas.drawRect(0,0, 500, 500, paint);
    }
}
