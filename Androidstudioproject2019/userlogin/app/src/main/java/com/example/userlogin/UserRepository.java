package com.example.userlogin;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private LiveData<List<User>>allUserLive;
    private UserDao userDao;

    UserRepository(Context context){
        UserDatabase userDatabase  = UserDatabase.getDatabase(context.getApplicationContext());
        userDao = userDatabase.getUserDao();
        allUserLive = userDao.getAllUsersLive();
    }

    //操作数据接口
    void insertUsers(User... users){
        new InsertAsyncTask(userDao).execute(users);
    }
    void updateUsers(User... users){
        new UpdateAsyncTask(userDao).execute(users);
    }
    void deleteUsers(User... users){
        new DeleteAsyncTask(userDao).execute(users);
    }
    LiveData<List<User>>getAllUserLive(){
        return allUserLive;
    }


    //修改
    static class InsertAsyncTask extends AsyncTask<User,Void,Void>{
        private UserDao userDao;
        InsertAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insertUser(users);
            return null;
        }
    }


    //修改
    static class UpdateAsyncTask extends AsyncTask<User,Void,Void>{
        private UserDao userDao;
        UpdateAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.updateUser(users);
            return null;
        }
    }

    //删除
    static class DeleteAsyncTask extends AsyncTask<User,Void,Void>{
        private UserDao userDao;
        DeleteAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.deleteUser(users);
            return null;
        }
    }


}
