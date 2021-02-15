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
    private  EditText email;
    private EditText BN;//Building number
    private EditText Type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        name=findViewById(R.id.NewUserName);
        pass=findViewById(R.id.NewUserPassword);
        email=findViewById(R.id.NewUserEmail);
        BN=findViewById(R.id.NewUserBuildingNum);
        Type=findViewById(R.id.NewUserType);
    }

    public void btnSend(View view) {
        Toast.makeText(this,"Name: "+ name.getText()+", Password: "+ pass.getText()+", email: "+ email.getText()+", Building number: "+BN.getText()+", type: "+Type.getText(),Toast.LENGTH_LONG).show();
    }

    public void GoBack(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}