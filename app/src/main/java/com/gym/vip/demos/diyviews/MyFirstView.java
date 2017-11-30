package com.gym.vip.demos.diyviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import java.io.InputStream;

/**
 * Created by Administrator on 2017\11\30 0030.
 */

public class MyFirstView extends View{

    private String mtext;
    private int msrc;

    public MyFirstView(Context context) {
        super(context);
    }

    public MyFirstView(Context context, AttributeSet attrs) {
        super(context, attrs);
        int resourceId = 0;
        int textId = attrs.getAttributeResourceValue(null, "Text",0);
        int srcId = attrs.getAttributeResourceValue(null, "Src", 0);
        mtext = context.getResources().getText(textId).toString();
        msrc = srcId;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        InputStream is = getResources().openRawResource(msrc);
        Bitmap mBitmap = BitmapFactory.decodeStream(is);
        int bh = mBitmap.getHeight();
        int bw = mBitmap.getWidth();

//        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
//        int width = wm.getDefaultDisplay().getWidth();
//        int height = wm.getDefaultDisplay().getHeight();
//        canvas.drawBitmap(mBitmap, width/2,height/2, paint);
//        canvas.drawText(mtext, width/2+bw/2, height/2+30, paint);

        canvas.drawBitmap(mBitmap, 0,0, paint);
        canvas.drawText(mtext, bw/2, 30, paint);
    }
}
