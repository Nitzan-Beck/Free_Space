package com.example.free_space;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void btnBackTOMainMenu(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}