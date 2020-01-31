package com.example.androidbaic2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidbaic2019.DataBinding.DataBindingTest;
import com.example.androidbaic2019.LiveData.LiveDataTest;
import com.example.androidbaic2019.LiveData.ViewModelWithLiveData;
import com.example.androidbaic2019.NavigationDemo01.NavigatiionDemo;
import com.example.androidbaic2019.Room.RoomTest;
import com.example.androidbaic2019.UI.UIDemo;
import com.example.androidbaic2019.Viewmdel.ViewModelTest;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUi,mBtnNavigation,mBtnViewModel,mBtnVMLiveData,mBtnDataBinding,mBtnRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUi = findViewById(R.id.btn_ui);
        mBtnNavigation = findViewById(R.id.btn_nvg);
        mBtnViewModel = findViewById(R.id.btn_viewmdel);
        mBtnVMLiveData = findViewById(R.id.btn_livedata);
        mBtnDataBinding = findViewById(R.id.btn_dataBinding);
        mBtnRoom = findViewById(R.id.btn_room);

        Onclick onclick = new Onclick();

        mBtnUi.setOnClickListener(onclick);
        mBtnNavigation.setOnClickListener(onclick);
        mBtnViewModel.setOnClickListener(onclick);
        mBtnVMLiveData.setOnClickListener(onclick);
        mBtnDataBinding.setOnClickListener(onclick);
        mBtnRoom.setOnClickListener(onclick);
    }

    class Onclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIDemo.class);
                    break;

                case R.id.btn_nvg:
                    intent = new Intent(MainActivity.this, NavigatiionDemo.class);
                    break;

                case R.id.btn_viewmdel:
                    intent = new Intent(MainActivity.this, ViewModelTest.class);
                    break;

                case R.id.btn_livedata:
                    intent = new Intent(MainActivity.this, LiveDataTest.class);
                    break;

                case R.id.btn_dataBinding:
                    intent = new Intent(MainActivity.this, DataBindingTest.class);
                    break;

                case R.id.btn_room:
                    intent = new Intent(MainActivity.this, RoomTest.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
