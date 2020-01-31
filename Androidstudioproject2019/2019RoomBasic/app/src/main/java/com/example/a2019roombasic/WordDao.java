package com.example.a2019roombasic;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao        //Database access object
public interface WordDao {
    @Insert
    void insertWords(Word... words);
    @Update
    void updateWords(Word... words);
    @Delete
    void deleteWords(Word... words);
    @Query("delete from Word")
    void deleteAllWords();
    @Query("select * from Word order by id desc")   //查询所有内容降序排列
    List<Word> getAllWords();
}
