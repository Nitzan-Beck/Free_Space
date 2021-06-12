package com.example.free_space;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class SingIn extends AppCompatActivity {
    private EditText name;
    private EditText pass;
    FirebaseDatabase database;
    DatabaseReference myRef;
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
        String username = String.valueOf(name.getText());
        String password = String.valueOf(pass.getText());

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        Query q = this.myRef.child("Workers").orderByValue();

        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userId = "null";
                for (DataSnapshot dst : dataSnapshot.getChildren()) {
                    WorkerItem temp = dst.getValue(WorkerItem.class);

                    assert temp != null;
                    if (username.equals(temp.getName()) && password.equals(temp.getPassword())) {
                        userId = dst.getKey();

                        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();

                        editor.putString("user_id", userId);

                        editor.commit(); // commit changes

                        //move to Worker\Boss menu
                        if (temp.gettype().equals("Worker"))
                        {
                            Intent i = new Intent(SingIn.this, Worker.class);
                            startActivity(i);
                        }
                        else if (temp.gettype().equals("Boss"))
                        {
                            Intent i = new Intent(SingIn.this, Boss.class);
                            startActivity(i);
                        }
                    }
                }

                assert userId != null;
                if (userId.equals("null")){
                    Toast.makeText(SingIn.this, "user doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


}