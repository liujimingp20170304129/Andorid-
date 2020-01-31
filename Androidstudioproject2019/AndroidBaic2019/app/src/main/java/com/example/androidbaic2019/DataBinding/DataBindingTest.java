package com.example.androidbaic2019.DataBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidbaic2019.R;
import com.example.androidbaic2019.databinding.ActivityDataBindingTestBinding;

public class DataBindingTest extends AppCompatActivity {

//    Button button;
//    TextView textView;
    MyViewModelDataBinding myViewModelDataBinding;
    ActivityDataBindingTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding_test);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

//        button = findViewById(R.id.button5);
//        textView = findViewById(R.id.textView5);

        myViewModelDataBinding = ViewModelProviders.of(this).get(MyViewModelDataBinding.class);
        myViewModelDataBinding.getNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.textView5.setText(String.valueOf(integer));
            }
        });

        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModelDataBinding.add();
            }
        });
    }
}
