package com.example.jc321013.imageloader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jc321013 on 9/05/2017.
 */

public class MyView extends View {

    private Paint paint;
    private PointF[] points;
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.BLACK);
    }

    public  void setPoints(PointF[] points){
        this.points = points;
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (points == null) return;

        for (PointF point : points){
            RectF rect = new RectF(point.x, point.y, point.x + 40, point.y + 40);
            canvas.drawRect(rect, paint);
        }

    }
}
