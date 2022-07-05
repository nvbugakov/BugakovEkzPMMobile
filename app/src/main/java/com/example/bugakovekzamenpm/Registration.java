package com.example.bugakovekzamenpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText email, password, repeatpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repeatpassword = findViewById(R.id.repeatpassword);
    }
    public void goMenu(View view) {   // Проверка на пустые поля, корректность введеной почты и переходы на экран
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
        if(TextUtils.isEmpty(repeatpassword.getText().toString()))
        {
            repeatpassword.setError("Введите пароль повторно");
            return;
        }
        if(password.getText().toString().equals(repeatpassword.getText().toString())){ // Проверка на совпадение паролей
            Toast.makeText(getApplicationContext(), "Регистрация прошла успешно",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Пароли не совпадают",
                    Toast.LENGTH_LONG).show();
            return;
        }

        Intent gomenu = new Intent(Registration.this, Menu.class);
        startActivity(gomenu);
    }
    public void goAuth(View view) { // Переход на экран авторизации
        Intent goauth = new Intent(Registration.this, MainActivity.class);
        startActivity(goauth);
    }
}