package com.example.userlogin;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User... users);

    @Update
    void updateUser(User... users);

    @Delete
    void deleteUser(User... users);


    @Query("select * from user ")
    LiveData<List<User>>getAllUsersLive();

//    @Query("select ed_User from user ")
//    LiveData<List<User>>getUserLive();
//
//    @Query("select * from user ")
//    LiveData<List<User>>getAllPasswords();

//    @Query("select ed_password from user ")
//    LiveData<List<User>>getPassword();
}
