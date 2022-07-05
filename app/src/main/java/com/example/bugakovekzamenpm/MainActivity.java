package com.example.bugakovekzamenpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btngomenu;
    EditText email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btngomenu =  findViewById(R.id.btngomenu);
    }
    public void goMenu(View view) { // Проверка на пустые поля, корректность почты и переход на экран
        String emailToText = email.getText().toString();
        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
        } else if (emailToText.isEmpty()){
            email.setError("Введи Email");
            return;
        } else {
            email.setError("Введите корректный Email");
            return;
        }

        if(TextUtils.isEmpty(password.getText().toString()))
        {
            password.setError("Введите password");
            return;
        }
        Intent gomenu = new Intent(MainActivity.this, Menu.class); //переход на экран Меню
        startActivity(gomenu);
    }
    public void GoRestration(View view) { // переход на страницу регистрации
        Intent goreg = new Intent(MainActivity.this, Registration.class);
        startActivity(goreg);
    }
}