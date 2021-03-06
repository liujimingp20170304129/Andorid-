package com.example.rememberwords;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//创建实体类
@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "english_word")
    private String word;

    @ColumnInfo(name = "chinese_meaing")
    private String chineseMeaning;

    @ColumnInfo(name = "hidden_chinese")
    private boolean hiddenChinese;

    boolean isHiddenChinese() {
        return hiddenChinese;
    }

    void setHiddenChinese(boolean hiddenChinese) {
        this.hiddenChinese = hiddenChinese;
    }


    public Word(String word, String chineseMeaning) {
        this.word = word;
        this.chineseMeaning = chineseMeaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    String getChineseMeaning() {
        return chineseMeaning;
    }

    public void setChineseMeaning(String chineseMeaning) {
        this.chineseMeaning = chineseMeaning;
    }
}
