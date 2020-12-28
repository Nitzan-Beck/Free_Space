package com.example.free_space;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SingUp extends AppCompatActivity {
    private EditText name;
    private EditText pass;
    private  EditText Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
    }

    public void btnSend(View view) {
        Toast.makeText(this,"Name: "+ name.getText()+", Password: "+ pass.getText(),Toast.LENGTH_LONG).show();

    }

    public void GoBack(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}