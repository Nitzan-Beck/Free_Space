package com.example.free_space;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.buttonSIgnIn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog SignInDialog=new Dialog(MainActivity.this);
                SignInDialog.setContentView(R.layout.sign_in_dialog);
                Button btn2;
                btn2=(Button) SignInDialog.findViewById(R.id.submit);
                btn2.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                   SignInDialog.dismiss();
                  }
                });

                SignInDialog.show();

            }
        });
    }

    //public void btnSignIn(View view) {
      //  Intent i=new Intent(this, SingIn.class);
        //startActivity(i);
    //}


    public void btnSignUp(View view) {
        Intent i=new Intent(this, SingUp.class);
        startActivity(i);
    }

    public void btnSettings(View view) {
        Intent i=new Intent(this, Settings.class);
        startActivity(i);
    }
}