package com.example.free_space;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SingUp extends AppCompatActivity {
    private EditText name;
    private EditText pass;
    private  EditText email;
    private EditText BN;//Building number
    private EditText RN; //Room number
    private EditText Type;
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        name=findViewById(R.id.NewUserName);
        pass=findViewById(R.id.NewUserPassword);
        email=findViewById(R.id.NewUserEmail);
        BN=findViewById(R.id.NewUserBuildingNum);
        Type=findViewById(R.id.NewUserType);
        RN=findViewById(R.id.NewUserRoomNumber);
    }

    public void btnSend(View view) {
        Toast.makeText(this,"Name: "+ name.getText()+", Password: "+ pass.getText()+", email: "+ email.getText()+", Building number: "+BN.getText()+", type: "+Type.getText(),Toast.LENGTH_LONG).show();
        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        AddWorker();
    }
    private void AddWorker()
    {
        WorkerItem WI= new WorkerItem(""+name.getText(), 2,"sdsd",3,"Boss");
        myRef.child("Workers").child(WI.getName()).setValue(WI);
//        myRef.child("workers").child(""+name.getText()).child("Name: ").setValue(" "+name.getText());
//        myRef.child("workers").child(""+name.getText()).child("Password: ").setValue(" "+pass.getText());
//        myRef.child("workers").child(""+name.getText()).child("email: ").setValue(" "+email.getText());
//        myRef.child("workers").child(""+name.getText()).child("Building number: ").setValue(" "+BN.getText());
//        myRef.child("workers").child(""+name.getText()).child("type: ").setValue(" "+Type.getText());
    }

    public void GoBack(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}