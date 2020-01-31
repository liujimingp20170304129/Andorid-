package com.example.androidbaic2019.LiveData;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelWithLiveData extends ViewModel {
    private MutableLiveData<Integer> LikedNumber;
    //因为上面的LikedNumber是对象类型不是原始数据
    //为了防止LikedNumber对象不为空，有两种方式
    //方法一
//    ViewModelWithLiveData(){
//        LikedNumber = new MutableLiveData<>();
//        LikedNumber.setValue(0);
//    }

    //方法二
    public MutableLiveData<Integer> getLikedNumber() {
        //判断LikedNumber是否为空，为空则创建一个，并且初始化为0，最后返回给访问者
        if (LikedNumber == null) {
            LikedNumber = new MutableLiveData<>();
            LikedNumber.setValue(0);
        }
        return LikedNumber;
    }

    public void addLikedNumber(int n) {
        LikedNumber.setValue(LikedNumber.getValue() + n);
    }
}
