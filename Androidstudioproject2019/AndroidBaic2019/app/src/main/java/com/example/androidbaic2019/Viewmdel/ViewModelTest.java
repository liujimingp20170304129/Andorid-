package com.example.androidbaic2019.Viewmdel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidbaic2019.R;

public class ViewModelTest extends AppCompatActivity {

    MyViewModel myViewModel;
    TextView textView;
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_test);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        textView = findViewById(R.id.textView4);

        textView.setText(String.valueOf(myViewModel.number));

        button1 = findViewById(R.id.button3);
        button2 = findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.number++;
                textView.setText(String.valueOf(myViewModel.number));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.number += 2;
                textView.setText(String.valueOf(myViewModel.number));

            }
        });
    }
}
