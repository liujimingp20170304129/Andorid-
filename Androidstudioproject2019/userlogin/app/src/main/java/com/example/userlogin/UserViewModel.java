package com.example.userlogin;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class UserViewModel extends AndroidViewModel {
    private UserDao userDao;
    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application){
        super(application);
    }


}
