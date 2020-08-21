package com.example.canvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;


public class Canvas_1 extends View {
    private Fragment_1.Fragment1Listener listener;
    Bitmap bit;
    Canvas mcan;
    Paint paint;
    int black;
    Path touch;


    public Canvas_1(Context context, Fragment_1.Fragment1Listener fragment1Listener) {
        this(context, null,fragment1Listener);
    }

    public Canvas_1(Context context, @Nullable AttributeSet attrs, Fragment_1.Fragment1Listener fragment1Listener) {
        super(context, attrs);
        this.listener = fragment1Listener;
        touch = new Path();
        black = ResourcesCompat.getColor(getResources(), R.color.colorPrimaryDark, null);
        paint = new Paint();
        setPaint(paint, black, 10, 50);
    }

    private void setPaint(Paint paint, int color, double stroke, int size) {
        paint.setColor(color);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setTextSize(size);
        paint.setStrokeWidth((float) stroke);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bit = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mcan = new Canvas(bit);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bit != null)
            canvas.drawBitmap(bit, 0, 0, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float px = event.getX();
        float py = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touch.moveTo(px, py);
                break;
            case MotionEvent.ACTION_MOVE:
                touch.lineTo(px, py);
                mcan.drawPath(touch, paint);
                listener.input(touch);
                break;
            case MotionEvent.ACTION_UP:
                touch.lineTo(px, py);
                mcan.drawPath(touch, paint);
                listener.input(touch);
                touch = new Path();
                break;
        }
        invalidate();
        return true;
    }
}

