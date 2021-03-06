package com.example.free_space;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
    }

    public void btnSend(View view) {
        Toast.makeText(this,"Name: "+ name.getText()+", Password: "+ pass.getText()+", email: "+ email.getText()+", Building number: "+BN.getText()+", type: "+Type.getText(),Toast.LENGTH_LONG).show();
        // Write a message to the database

        AddWorker();
    }
    private void AddWorker()
    {
        WorkerItem WI= new WorkerItem(String.valueOf(name.getText()),
                Integer.parseInt(String.valueOf(RN.getText())),
                String.valueOf(this.email.getText()),
                Integer.parseInt(String.valueOf(BN.getText())),
                String.valueOf(Type.getText()),
                String.valueOf(pass.getText()));

        String userID = this.myRef.child("Workers").push().getKey();
        assert userID != null;
        myRef.child("Workers").child(userID).setValue(WI);

        //block option to add new admin
        if (!WI.gettype().equals("Admin") && !WI.gettype().equals("CEO")){
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();

            editor.putString("user_id", userID);

            editor.commit(); // commit changes

            Intent i = new Intent(this, Boss.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this,"adding new admin is invalid",Toast.LENGTH_LONG).show();
        }
    }

    public void GoBack(View view) {
        Intent i=new Intent(this,Boss.class);
        startActivity(i);
    }
}