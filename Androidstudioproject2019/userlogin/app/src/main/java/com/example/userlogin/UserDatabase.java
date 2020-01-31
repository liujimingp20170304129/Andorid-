package com.example.userlogin;

import android.content.Context;
import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    static synchronized UserDatabase getDatabase(Context context){
        return null;
    }
    public abstract UserDao getUserDao();
}
