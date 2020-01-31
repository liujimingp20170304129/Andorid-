package com.example.serializable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText editTextName,editTextAge,editTextMath,editTextEnglish,editTextChinese;
    Button buttonSave,buttonLoad;
    TextView textViewGrade;
    private static final String FILE_NAME = "myfile.data";
    private static final String TAG = "hello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextChinese = findViewById(R.id.editTextChinese);
        editTextEnglish = findViewById(R.id.editTextEnglish);
        editTextMath = findViewById(R.id.editTextMath);
        textViewGrade = findViewById(R.id.textViewGrade);
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        buttonSave = findViewById(R.id.buttonSave);
        buttonLoad = findViewById(R.id.buttonLoad);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int math = Integer.valueOf(editTextMath.getText().toString());
                int english = Integer.valueOf(editTextEnglish.getText().toString());
                int chinese = Integer.valueOf(editTextChinese.getText().toString());
                Score score = new Score(math,english,chinese);
                String name = editTextName.getText().toString();
                int age = Integer.valueOf(editTextAge.getText().toString());
                Student student = new Student(name,age,score);

                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(openFileOutput(FILE_NAME,MODE_PRIVATE));
                    objectOutputStream.writeObject(student);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    Toast.makeText(MainActivity.this, "Data Save!", Toast.LENGTH_SHORT).show();
                    editTextChinese.getText().clear();
                    editTextEnglish.getText().clear();
                    editTextMath.getText().clear();
                    editTextName.getText().clear();
                    editTextAge.getText().clear();
                    textViewGrade.setText("-");
                }catch (IOException e){
                    Log.e(TAG, "onClick: ",e );
                }
            }
        });

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                   ObjectInputStream objectInputStream = new ObjectInputStream(openFileInput(FILE_NAME));
                   Student student = (Student) objectInputStream.readObject();
                   editTextName.setText(student.getName());
                   editTextAge.setText(String.valueOf(student.getAge()));
                   editTextMath.setText(String.valueOf(student.getScore().getMath()));
                   editTextEnglish.setText(String.valueOf(student.getScore().getEnglish()));
                   editTextChinese.setText(String.valueOf(student.getScore().getChinese()));
                   textViewGrade.setText(student.getScore().getGrade());
                }catch (IOException e){
                    Log.e(TAG, "onClick: ",e );
                }catch (ClassNotFoundException e){
                    Log.d(TAG, "onClick: ",e );
                }
            }
        });
    }
}
