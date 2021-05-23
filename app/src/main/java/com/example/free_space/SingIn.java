package com.example.free_space;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SingIn extends AppCompatActivity {
    private EditText name;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        name=findViewById(R.id.editTextTxtUserName);
        pass=findViewById(R.id.UserPassword);
    }

    public void btnBackToMainMenu(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void Send(View view) {
        Toast.makeText(this,"Name: "+ name.getText()+", Password: "+ pass.getText(),Toast.LENGTH_LONG).show();
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
    }
}