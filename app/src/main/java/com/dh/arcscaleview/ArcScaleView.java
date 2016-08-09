package com.dh.arcscaleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dh on 16-8-9.
 */
public class ArcScaleView extends View {

    private Paint mArcPaint = new Paint();
    private Paint mCirclePaint = new Paint();
    private Paint mTextPaint = new Paint();

    private int width;
    private int mCircleXY;
    private float mRadius;

    private float mSweepAngle;
    private String mShowText;

    public ArcScaleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        mArcPaint.setColor(Color.BLUE);
        mArcPaint.setAntiAlias(true);
        mArcPaint.setDither(true);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth(60);
        mArcPaint.setStrokeCap(Paint.Cap.ROUND);

        mCirclePaint.setColor(Color.YELLOW);
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setDither(true);
        mCirclePaint.setStyle(Paint.Style.FILL);

        mTextPaint.setColor(Color.RED);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setDither(true);
        mTextPaint.setStyle(Paint.Style.STROKE);
    }

    public void setSweepValue(float sweepValue){
        if(sweepValue != 0)
            mSweepAngle = sweepValue;
        else
            mSweepAngle = 25;
        this.invalidate();
    }

    public void setText(String showText){
        mShowText = showText;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF mRectF = new RectF((float)(width*0.1), (float)(width*0.1), (float)(width*0.9), (float)(width*0.9));

        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        canvas.drawArc(mRectF, 270, mSweepAngle, false, mArcPaint);
        canvas.drawText(mShowText, 0, mShowText.length(), mCircleXY-(mShowText.length()/4),
                mCircleXY+(mShowText.length()/4), mTextPaint);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mCircleXY = width/2;
        mRadius = (float)(width * 0.5 / 2);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        width = Math.min(widthSize, heightSize);

        if(widthMode == MeasureSpec.UNSPECIFIED)
            width = heightSize;
        else if(heightMode == MeasureSpec.UNSPECIFIED)
            width = widthSize;

        setMeasuredDimension(width, width);
    }
}
