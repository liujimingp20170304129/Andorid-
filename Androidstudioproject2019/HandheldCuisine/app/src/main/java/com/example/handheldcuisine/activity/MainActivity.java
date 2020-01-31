package com.example.handheldcuisine.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.handheldcuisine.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    Animation myAnimation;                             //动画的引用
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置为无标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置为全屏模式
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        //创建Timer对象
        Timer timer = new Timer();
        //创建TimerTask对象
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ContainerActivity.class);
                startActivity(intent);
                finish();
            }
        };
        //使用timer.schedule（）方法调用timerTask，定时3秒后执行run
        timer.schedule(timerTask, 5000);

        myAnimation = AnimationUtils.loadAnimation(this,R.anim.myanim);     //加载动画
        imageView = (ImageView) findViewById(R.id.myimageview);
        imageView.startAnimation(myAnimation);
    }
}
