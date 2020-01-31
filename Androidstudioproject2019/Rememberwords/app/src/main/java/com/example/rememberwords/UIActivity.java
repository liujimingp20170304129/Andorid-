package com.example.rememberwords;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import android.view.WindowManager;

import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class UIActivity extends Activity {
    private int recLen = 5;//跳过倒计时提示5秒
    private TextView tv_over;
    private Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;


    public UIActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);
        setContentView(R.layout.activity_ui);
        initView();
        timer.schedule(task, 1000, 1000);//等待时间一秒，停顿时间一秒
        /**
         * 正常情况下不点击跳过
         */
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                //从闪屏界面跳转到首界面
                Intent intent = new Intent(UIActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);//延迟5S后发送handler信息

    }

    private void initView() {
        tv_over = findViewById(R.id.tv_over);
        tv_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.tv_over:
                        //从闪屏界面跳转到首界面
                        Intent intent = new Intent(UIActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        if (runnable != null) {
                            handler.removeCallbacks(runnable);
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        }
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() { // UI thread
                    @Override
                    public void run() {
                        recLen--;
                        tv_over.setText("跳过 " + recLen);
                        if (recLen < 0) {
                            timer.cancel();
                            tv_over.setVisibility(View.GONE);//倒计时到0隐藏字体
                        }
                    }
                });
            }
        };



    }

