package com.example.serializable;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private Score score;

    public Student(String name, int age, Score score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}

class Score implements  Serializable{
    private int math;
    private int English;
    private int Chinese;
    private String grade;

    public Score(int math, int english, int chinese) {
        this.math = math;
        English = english;
        Chinese = chinese;
        if(math>=90 && english >= 90 & chinese >= 90){
            this.grade = "A";
        }else if(math>=80 && english >= 80 & chinese >= 80){
            this.grade = "B";
        }else {
            this.grade = "C";
        }
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

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
