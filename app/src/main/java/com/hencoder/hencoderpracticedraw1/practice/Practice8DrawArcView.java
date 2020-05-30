package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private Paint paint1;
    private Paint paint2;
    private Paint paint3;

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint1 = new Paint();
        paint1.setColor(Color.BLACK);
        paint1.setAntiAlias(true);
        paint1.setStyle(Paint.Style.FILL);


        paint2 = new Paint();
        paint2.setColor(Color.BLACK);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);

        paint3 = new Paint();
        paint3.setColor(Color.BLACK);
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.FILL);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        /**
         * 参数意义 矩形的四条边，弧形起始角度，弧形划过的角度(顺时针为正角度，逆时针为负角度)，是否连接到圆心
         */
        canvas.drawArc(360,300,710,490,-110,100,true,paint1);

        canvas.drawArc(360,300,710,490,-180,60,false,paint2);

        canvas.drawArc(360,300,710,490,160,-140,false,paint3);
    }
}
