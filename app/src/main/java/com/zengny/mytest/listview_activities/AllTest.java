package com.zengny.mytest.listview_activities;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zengny.mytest.R;

/**
 * Created by 曾南勇
 * on 2016/11/30.
 */

public class AllTest extends Activity {
    private TextView tv;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alltest);
        tv = (TextView) findViewById(R.id.tv);
        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int height = (int) tv.getY();
                int wigth = (int) tv.getX();
                Log.e("zengny","x=" + wigth );
                Log.e("zengny","y=" + height );
                tv.scrollBy(wigth + 20,height + 20);
                ObjectAnimator.ofFloat(bt,"translationY", 0 , 150).setDuration(1000).start();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ObjectAnimator.ofFloat(bt,"translationY", 0 , -150).setDuration(1000).start();
                    }
                }, 1000);

            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("zengny","ev=" + ev );
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}
