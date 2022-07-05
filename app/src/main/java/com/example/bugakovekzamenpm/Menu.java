package com.example.bugakovekzamenpm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Objects;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @SuppressLint({"NonConstantResourceId", "ShowToast"})
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { // Выводы сообщение при нажатие в toolbar'e кнопок, а так же переходы
        switch (item.getItemId()){
            case
                    R.id.profile:
                Toast.makeText(this, "you click profile", Toast.LENGTH_LONG).show();
                break;
            case
                    R.id.history:
                Toast.makeText(this, "you click history", Toast.LENGTH_LONG).show();
                Intent gohist = new Intent(Menu.this, History.class);
                startActivity(gohist);
                break;
            case
                    R.id.settings:
                Toast.makeText(this, "you click settings", Toast.LENGTH_LONG).show();
                Intent gosett = new Intent(Menu.this, Settings.class);
                startActivity(gosett);

                break;
            default:
                break;


        }
        return true;
    }
}