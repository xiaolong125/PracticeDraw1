package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    private static final int RADIUS = 230;
    private Paint paint1;
    private Path path;
    private Paint linePaint;
    private Paint textPaint;
    private Paint paint2;
    private Paint paint3;
    private Paint paint4;
    private Paint paint5;
    private Paint paint6;
    private Paint paint;

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        linePaint = new Paint();
        linePaint.setColor(Color.WHITE);
        linePaint.setStrokeWidth(2);
        linePaint.setAntiAlias(true);
        linePaint.setStyle(Paint.Style.STROKE);

        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(25);

        paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);
        paint1.setColor(Color.parseColor("#F44336"));
        path = new Path();

        paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint2.setColor(Color.parseColor("#2196F3"));

        paint3 = new Paint();
        paint3.setStyle(Paint.Style.FILL);
        paint3.setAntiAlias(true);
        paint3.setColor(Color.parseColor("#009688"));

        paint4 = new Paint();
        paint4.setStyle(Paint.Style.FILL);
        paint4.setAntiAlias(true);
        paint4.setColor(Color.parseColor("#9E9E9E"));

        paint5 = new Paint();
        paint5.setStyle(Paint.Style.FILL);
        paint5.setAntiAlias(true);
        paint5.setColor(Color.parseColor("#9C27B0"));

        paint6 = new Paint();
        paint6.setStyle(Paint.Style.FILL);
        paint6.setAntiAlias(true);
        paint6.setColor(Color.parseColor("#FFC107"));

        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);


    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        //Lollipop
        canvas.drawArc(200,150,200+ RADIUS * 2 ,150+RADIUS*2,-180,120,true,paint1);
        path.moveTo(160,180);
        path.rLineTo(100,0);
        path.rLineTo(22,22);
        canvas.drawPath(path,linePaint);
        canvas.drawText("Lollipop",40,180,textPaint);


        //KitKat
        canvas.drawArc(220,170,210+ RADIUS * 2 ,170+RADIUS*2,178,-104,true,paint2);
        path.moveTo(180,150+RADIUS*2);
        path.rLineTo(100,0);
        path.rLineTo(27,-27);
        canvas.drawPath(path,linePaint);
        canvas.drawText("KitKat",90,150+RADIUS*2,textPaint);

        //Jelly Bean
        canvas.drawArc(220,170,210+RADIUS*2,170+RADIUS*2,72,-53,true, paint3);
        path.moveTo(210+RADIUS*2+70,170+RADIUS*2-30);
        path.rLineTo(-100,0);
        path.rLineTo(-36,-36);
        canvas.drawPath(path,linePaint);
        canvas.drawText("Jelly Bean",210+RADIUS*2+80,150+RADIUS*2,textPaint);

        //Ice Cream Sandwich
        canvas.drawArc(220,170,210+RADIUS*2,170+RADIUS*2,17,-5,true, paint4);
        path.moveTo(210+RADIUS*2+70,170+RADIUS*2-148);
        path.rLineTo(-22,0);
        path.rLineTo(-22,-22);
        path.rLineTo(-32,0);
        canvas.drawPath(path,linePaint);
        canvas.drawText("Ice Cream Sandwich",210+RADIUS*2+80,170+RADIUS*2-145,textPaint);

        //Gingerbread
        canvas.drawArc(220,170,210+RADIUS*2,170+RADIUS*2,10,-7,true, paint5);
        path.moveTo(210+RADIUS*2+70,170+RADIUS*2-173);
        path.rLineTo(-20,0);
        path.rLineTo(-27,-27);
        path.rLineTo(-24,0);
        canvas.drawPath(path,linePaint);
        canvas.drawText("Gingerbread",210+RADIUS*2+80,170+RADIUS*2-170,textPaint);

        //Froyo
        path.moveTo(210+RADIUS*2+70,170 + RADIUS + 6);
        path.rLineTo(-70,0);
        canvas.drawPath(path,linePaint);
        canvas.drawText("Froyo",210+RADIUS*2+80,170 + RADIUS + 6,textPaint);

        //Marshmalllow
        canvas.drawArc(220,170,210+RADIUS*2,170+RADIUS*2,1,-60,true, paint6);
        path.moveTo(210+RADIUS*2+70,170+80);
        path.rLineTo(-87,0);
        path.rLineTo(-20,20);
        canvas.drawPath(path,linePaint);
        canvas.drawText("Marshmalllow",210+RADIUS*2+80,170+80,textPaint);

        canvas.drawText("饼图",220+(RADIUS-getTextWidth(paint,"饼图")/2),170+RADIUS*2+80,paint);

    }

    public static int getTextWidth(Paint paint, String str) {
        int iRet = 0;
        if (str != null && str.length() > 0) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                iRet += (int) Math.ceil(widths[j]);
            }
        }
        return iRet;
    }
}
