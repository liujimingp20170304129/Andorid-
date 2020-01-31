package com.example.jsondemo;

public class Score {
    private int Math;
    private int English;
    private int Chinese;


    public Score(int math, int english, int chinese) {
        Math = math;
        English = english;
        Chinese = chinese;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int chinese) {
        Chinese = chinese;
    }


}
