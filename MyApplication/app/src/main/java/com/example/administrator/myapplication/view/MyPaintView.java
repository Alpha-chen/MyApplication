package com.example.administrator.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * @author xupangen on 2018/1/25.
 */

public class MyPaintView extends View implements View.OnClickListener {
    public MyPaintView(Context context) {
        this(context, null);
    }

    public MyPaintView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyPaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    int width = 0;
    int height = 0;
    Paint paint = null;
    Paint rectPaint = null;
    Paint circlePaint = null;

    private void init() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                width = getMeasuredWidth();
                height = getMeasuredHeight();
                Log.d("MyPaintView", "onGlobalLayout");
            }
        });
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        paint.setTextSize(50);
        rectPaint = new Paint();
        rectPaint.setAlpha(20);
        rectPaint.setColor(Color.RED);
        circlePaint = new Paint();
        circlePaint.setColor(Color.BLUE);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, width, height, rectPaint);
        canvas.drawText("width->=" + width, width / 2, height / 2, paint);
        canvas.drawText("height->=" + height, width / 2, height / 3, paint);
        canvas.clipRect(new Rect(0, height / 2, width, height));
        canvas.drawCircle(width / 2, height * 3 / 4, height / 4, circlePaint);
    }

    @Override
    public void onClick(View v) {

    }
}
