package com.example.jsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Gson gson = new Gson();
        //序列化1
//        Student student1 = new Student("Jack",20);
//        String jsonStudent1 = gson.toJson(student1);
        //反序列化1
//        String jsonStudent1 = "{\"age\":20,\"name\":\"Jack\"}";
//        Student student1 = gson.fromJson(jsonStudent1,Student.class);


//          Gson gson = new Gson();
        //序列化2
//          Student student2 = new Student("Tom",19,new Score(90,85,90));
//          String jsonStudnet2 = gson.toJson(student2);
        //反序列化2
//        Student student2 ;
//        String jsonStudent2 = "{\n" +
//                "  \"age\": 19,\n" +
//                "  \"name\": \"Tom\",\n" +
//                "  \"score\": {\n" +
//                "    \"Chinese\": 90,\n" +
//                "    \"English\": 85,\n" +
//                "    \"Math\": 90\n" +
//                "  }\n" +
//                "}";
//        student2 = gson.fromJson(jsonStudent2,Student.class);






        //序列化3
        Gson gson = new Gson();
        //序列化多个对象
//        Student student1 = new Student("Mike",20,new Score(90,87,67));
//        Student student2 = new Student("Lisa",18,new Score(80,90,75));
//        Student[] students = {student1,student2};
//        String jsonStudents = gson.toJson(students);
        //反序列化多个对象
//        String jsonStudents = "[\n" +
//                "  {\n" +
//                "    \"age\": 20,\n" +
//                "    \"name\": \"Mike\",\n" +
//                "    \"score\": {\n" +
//                "      \"Chinese\": 67,\n" +
//                "      \"English\": 87,\n" +
//                "      \"Math\": 90\n" +
//                "    }\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"age\": 18,\n" +
//                "    \"name\": \"Lisa\",\n" +
//                "    \"score\": {\n" +
//                "      \"Chinese\": 75,\n" +
//                "      \"English\": 90,\n" +
//                "      \"Math\": 80\n" +
//                "    }\n" +
//                "  }\n" +
//                "]";
//        Student[] students = gson.fromJson(jsonStudents,Student[].class);

        //先转换成list在转换成序列化4
//        Student student1 = new Student("Mike",20,new Score(90,87,67));
//        Student student2 = new Student("Lisa",18,new Score(80,90,75));
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(student1);
//        studentList.add(student2);
//        String jsonStudnets = gson .toJson(studentList);

        //反序列化4
//        List<Student> studentList = new ArrayList<>();
//        String josnStudents = "[{\"age\":20,\"name\":\"Mike\",\"score\":{\"Chinese\":67,\"English\":87,\"Math\":90}},{\"age\":18,\"name\":\"Lisa\",\"score\":{\"Chinese\":75,\"English\":90,\"Math\":80}}]";
//        Type typeStudents = new TypeToken<List<Student>>(){}.getType();
//        studentList = gson.fromJson(josnStudents,typeStudents);

        //添加标记 @SerializedName序列化5
        Student student3 = new Student("Rose",20,new Score(90,80,85));
        String jsonStudent3 = gson.toJson(student3);

    }
}

