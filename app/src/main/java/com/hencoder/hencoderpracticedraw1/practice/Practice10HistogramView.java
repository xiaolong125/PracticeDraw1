package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    //每个直方的宽
    private int width = 90;

    //间隔
    private int distance = 20;
    //原点坐标
    private int x = 100;
    private int y = 600;

    //坐标轴宽高
    private int xWidth = 800;
    private int yHeight = 500;

    //坐标轴线的宽度
    private float lineWidth = 1.5f;

    private Paint paint1;
    private Paint paint2;
    private Paint paint3;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //画坐标轴
        paint1 = new Paint();
        paint1.setColor(Color.WHITE);
        paint1.setStrokeWidth(lineWidth);
        paint1.setAntiAlias(true);
        paint1.setTextSize(40);

        //画直方
        paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.parseColor("#72B916"));
        paint2.setAntiAlias(true);

        //直方下面的字
        paint3 = new Paint();
        paint3.setColor(Color.WHITE);
        paint3.setAntiAlias(true);
        paint3.setTextSize(25);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        //画坐标轴
        canvas.drawLine(x,y,x,y-yHeight,paint1);
        canvas.drawLine(x,y,x+xWidth,y,paint1);

        canvas.drawText("直方图",x + (xWidth - getTextWidth(paint1,"直方图"))/2,y+120,paint1);

        //第一组
        canvas.drawRect(x+distance,y - lineWidth -2,x+distance+width,y - lineWidth,paint1);
        canvas.drawText("Froyo",x + distance + (width - getTextWidth(paint3,"Froyo"))/2,y+20,paint3);

        //第二组
        canvas.drawRect(x+width+ 2* distance,y - lineWidth -20,x + 2 * width + 2* distance,y - lineWidth,paint2);
        canvas.drawText("GB",x + 2*distance+ width + (width - getTextWidth(paint3,"GB"))/2,y+20,paint3);

        //第三组
        canvas.drawRect(x + 2 * width + 3* distance,y - lineWidth -20,x + 3 * width + 3 * distance,y - lineWidth,paint2);
        canvas.drawText("ICS",x + 3*distance+ 2 * width + (width - getTextWidth(paint3,"ICS"))/2,y+20,paint3);

        //第四组
        canvas.drawRect(x + 3 * width + 4* distance,y - lineWidth -160,x + 4 * width + 4 * distance,y - lineWidth,paint2);
        canvas.drawText("JB",x + 4*distance+ 3 * width + (width - getTextWidth(paint3,"JB"))/2,y+20,paint3);

        //第五组
        canvas.drawRect(x + 4 * width + 5* distance,y - lineWidth -280,x + 5 * width + 5 * distance,y - lineWidth,paint2);
        canvas.drawText("KitKat",x + 5*distance+ 4 * width + (width - getTextWidth(paint3,"KitKat"))/2,y+20,paint3);

        //第六组
        canvas.drawRect(x + 5 * width + 6* distance,y - lineWidth -360,x + 6 * width + 6 * distance,y - lineWidth,paint2);
        canvas.drawText("L",x + 6*distance+ 5 * width + (width - getTextWidth(paint3,"L"))/2,y+20,paint3);

        //第七组
        canvas.drawRect(x + 6 * width + 7* distance,y - lineWidth -160,x + 7 * width + 7 * distance,y - lineWidth,paint2);
        canvas.drawText("M",x + 7*distance + 6 * width + (width - getTextWidth(paint3,"M"))/2,y+20,paint3);

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
