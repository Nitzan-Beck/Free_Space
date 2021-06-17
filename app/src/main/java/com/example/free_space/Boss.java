package com.example.free_space;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Boss extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    private EditText workerToDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss);

        this.workerToDelete = findViewById((R.id.workerToDeleteET));

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
    }

    public void btnBossLogout(View view) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        editor.clear(); // remove user id
        editor.commit(); // commit changes

        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void LookAsWorker(View view) {
        Intent i=new Intent(this,Worker.class);
        startActivity(i);
    }

    public void NewWorker(View view) {
        Intent i=new Intent(this,SingUp.class);
        startActivity(i);
    }

    public void deleteWorker(View view) {
        String userId = String.valueOf(this.workerToDelete.getText());
        myRef.child("Workers").child(userId).removeValue();
    }
}