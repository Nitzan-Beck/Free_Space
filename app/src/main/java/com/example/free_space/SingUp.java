package com.example.free_space;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SingUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
    }

    public void btnSend(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}