package com.example.handheldcuisine.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.handheldcuisine.R;
import com.example.handheldcuisine.adapter.ContainerAdapter;
import com.example.handheldcuisine.frament.HomeFrament;

public class ContainerActivity extends AppCompatActivity{
    private EditText editText;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mListView = (ListView)findViewById(R.id.mlistview);
        editText = (EditText)findViewById(R.id.ed_txt) ;
        //防止键盘弹出时把布局向上顶
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        mListView.setAdapter(new ContainerAdapter(ContainerActivity.this));
        //listView点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ContainerActivity.this,"点击 pos:"+position,Toast.LENGTH_SHORT).show();

            }
        });
        //ListView长按事件
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ContainerActivity.this,"长按 pos:"+position,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}
