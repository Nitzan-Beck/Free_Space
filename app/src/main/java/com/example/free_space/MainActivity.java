package com.example.free_space;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSingIn(View view) {
        Intent i=new Intent(this, SingIn.class);
        startActivity(i);
    }

    public void btnSingUp(View view) {
        Intent i=new Intent(this, SingUp.class);
        startActivity(i);
    }

    public void btnSettings(View view) {
        Intent i=new Intent(this, Settings.class);
        startActivity(i);
    }
}