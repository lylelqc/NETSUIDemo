package com.ntes.demo.paint;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.ntes.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * canvas粒子爆炸效果
 */
public class SplitView extends View {

    private Paint paint;
    private Bitmap bmp;
    private int d = 3;
    private List<Ball> mBalls = new ArrayList<>();
    private ValueAnimator mAnimator;


    public SplitView(Context context) {
        this(context, null);
    }

    public SplitView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SplitView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.pic);
        for(int i = 0; i< bmp.getWidth(); i++){
            for(int j = 0; j < bmp.getHeight(); j++){
                Ball ball = new Ball();
                ball.color = bmp.getPixel(i,j);
                ball.x = i * d + d / 2;
                ball.y = j * d + d / 2;
                ball.r = d / 2;

                // 速度（-20， 20）
                ball.vX = (float) (Math.pow(-1, Math.ceil(Math.random()*1000 )) * 20 * Math.random());
                ball.vY= rangInt(-15, 35);

                ball.aX = 0;
                ball.aY = 0.98f;

                mBalls.add(ball);
            }
        }

        mAnimator = ValueAnimator.ofFloat(0, 1);
        mAnimator.setRepeatCount(-1);
        mAnimator.setDuration(2000);
        mAnimator.setInterpolator( new LinearInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                updateBall();
                invalidate();
            }
        });
    }

    private int rangInt(int i, int j) {
        int max = Math.max(i, j);
        int min = Math.min(i, j);
        return (int) (min+ Math.ceil(Math.random() * ( max- min)));

    }

    private void updateBall() {
        // 更新粒子位置和速度
        for(Ball ball : mBalls){
             ball.x += ball.vX;
             ball.y += ball.vY;

             ball.vX += ball.aX;
             ball.vY += ball.aY;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(500, 500);
        for(Ball ball : mBalls){
            paint.setColor(ball.color);
            canvas.drawCircle(ball.x, ball.y, ball.r, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                // 执行动画
                mAnimator.start();
                break;
        }
        return super.onTouchEvent(event);
    }
}
