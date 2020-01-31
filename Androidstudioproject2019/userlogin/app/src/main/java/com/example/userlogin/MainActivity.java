package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button BtnLogin;
    private Button BtnRegister;
    private EditText EdUser;
    private EditText EdPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnLogin = findViewById(R.id.btn_login);
        BtnRegister = findViewById(R.id.btn_register);
        EdUser = findViewById(R.id.ed_login);
        EdPassword = findViewById(R.id.ed_passpword);

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
