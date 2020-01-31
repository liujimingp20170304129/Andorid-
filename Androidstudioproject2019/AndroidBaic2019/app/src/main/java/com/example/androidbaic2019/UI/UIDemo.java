package com.example.androidbaic2019.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidbaic2019.R;

public class UIDemo extends AppCompatActivity {

    TextView textView;
    Button mBtnLeft,mBtnRight,mBtnEnter;
    Switch aSwitch;
    ProgressBar progressBar;
    EditText editText;
    RadioGroup radioGroup;
    ImageView imageView;
    SeekBar seekBar;
    CheckBox checkBoxYuWen,checkBoxShuXue,checkBoxYingYu;
    RatingBar ratingBar;
    String yuwen = "";
    String shuxue = "";
    String yingyu = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uidemo);
        textView = findViewById(R.id.tv_hello);
        mBtnLeft = findViewById(R.id.btn_left);
        mBtnRight = findViewById(R.id.btn_right);
        aSwitch = findViewById(R.id.switch1);
        progressBar = findViewById(R.id.progressBar3);
        editText = findViewById(R.id.editText);
        mBtnEnter = findViewById(R.id.btn_enter);
        radioGroup = findViewById(R.id.radiogroup);
        imageView = findViewById(R.id.imageView2);
        seekBar = findViewById(R.id.seekBar);
        checkBoxYuWen = findViewById(R.id.checkBox);
        checkBoxShuXue = findViewById(R.id.checkBox2);
        checkBoxYingYu = findViewById(R.id.checkBox3);
        ratingBar = findViewById(R.id.ratingBar);

        mBtnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(R.string.btn_left);
            }
        });

        mBtnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(R.string.btn_right);
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    textView.setText(R.string.tv_open);
                }else {
                    textView.setText(R.string.tv_off);
                }
            }
        });

        mBtnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                if (TextUtils.isEmpty(s)){
                    s ="0";
                }
                progressBar.setProgress(Integer.valueOf(s));
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton){
                    imageView.setImageResource(R.drawable.ic_mood_black_24dp);
                }else {
                    imageView.setImageResource(R.drawable.ic_mood_bad_black_24dp);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        checkBoxYuWen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    yuwen = "语文";
                }else {
                    yuwen = "";
                }
                textView.setText(yuwen+shuxue+yingyu);
            }
        });

        checkBoxShuXue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    shuxue = "数学";
                }else {
                    shuxue = "";
                }
                textView.setText(yuwen+shuxue+yingyu);
            }
        });

        checkBoxYingYu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    yingyu = "英语";
                }else {
                    yingyu = "";
                }
                textView.setText(yuwen+shuxue+yingyu);
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(),String.valueOf(rating)+"星评价！",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
