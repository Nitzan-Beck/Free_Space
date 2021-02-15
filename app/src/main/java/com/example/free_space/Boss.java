package com.example.free_space;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Boss extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss);
    }

    public void btnBossLogout(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void LookAsWorker(View view) {
        Intent i=new Intent(this,Worker.class);
        startActivity(i);
    }

    public void NewWorker(View view) {
        Intent i=new Intent(this,SingIn.class);
        startActivity(i);
    }
}