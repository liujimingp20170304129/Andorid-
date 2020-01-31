package com.example.a2019roombasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    WordDatabase wordDatabase;
    WordDao wordDao;
    TextView textView;
    Button BtnInsert,BtnUpdate,BtnClear,BtnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordDatabase = Room.databaseBuilder(this,WordDatabase.class,"word_database")
                .allowMainThreadQueries()
                .build();
        wordDao = wordDatabase.getWordDao();
        textView = findViewById(R.id.textView);
        updateView();

        BtnInsert = findViewById(R.id.btn_insert);
        BtnUpdate = findViewById(R.id.btn_update);
        BtnClear = findViewById(R.id.btn_clear);
        BtnDelete = findViewById(R.id.btn_delete);
        //插入
        BtnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("word","你好！");
                Word word2 = new Word("word","世界！");
                wordDao.insertWords(word1,word2);
                updateView();
            }
        });
        //清除
        BtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordDao.deleteAllWords();
                updateView();
            }
        });

        //修改
        BtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hi","你好吖！");
                word.setId(22);
                wordDao.updateWords(word);
                updateView();
            }
        });
        //删除
        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hi","你好吖！");
                word.setId(20);
                wordDao.deleteWords(word);
                updateView();
            }
        });

    }
    void updateView(){
        List<Word> list = wordDao.getAllWords();
        String text = "";
        for (int i=0;i<list.size();i++){
            Word word = list.get(i);
            text += word.getId() + ":" + word.getWord() + "=" + word.getChineseMeaning() + "\n";
        }
        textView.setText(text);
    }
}
