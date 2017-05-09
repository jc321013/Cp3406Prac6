package com.example.jc321013.imageloader;

import android.graphics.Point;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    private MyView myView;
    private PointF[] points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myView = (MyView) findViewById(R.id.myView);

        points = new PointF[10];
        for (int i = 0; i < points.length; ++i){
            points[i] = new PointF();
        }

        myView.setPoints(points);

        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                System.out.println("" + event.getX() + event.getY());

                for (int i = 1; i < points.length; ++i){
                    points[i-1].x = points[i].x;
                    points[i-1].y = points[i].y;
                }

                points[points.length -1].x = event.getX();
                points[points.length -1].y = event.getX();

                for (PointF point : points) {
                    System.out.println(String.format("%s", point));

                }
                System.out.println();
                myView.invalidate(); //force redraw of the custom view




                return true;
            }
        });


    }
}
