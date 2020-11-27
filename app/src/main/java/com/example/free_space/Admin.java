package com.example.free_space;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class Admin extends AppCompatActivity {
    Button btnLookAs;
    String[] s={"look as worker", "Look as boss", "Look as CEO"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        btnLookAs=findViewById(R.id.LookAs);
        btnLookAs.setOnClickListener(btnLookAsListener);
    }
    private View.OnClickListener btnLookAsListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ArrayAdapter a=new ArrayAdapter(Admin.this,android.R.layout.simple_list_item_1,s);
            AlertDialog.Builder adb= new AlertDialog.Builder(Admin.this);
            adb.setTitle("Look as:");
            adb.setAdapter(a, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    if(s[i].equals("look as worker")){
                        Intent j=new Intent(Admin.this,Worker.class);
                        startActivity(j);
                    }
                    if (s[i].equals("Look as boss")){
                        Intent j=new Intent(Admin.this,Boss.class);
                        startActivity(j);
                    }
                    if (s[i].equals("Look as CEO")){
                        Intent j=new Intent(Admin.this,CEO.class);
                        startActivity(j);
                    }
                }
            });
            adb.create().show();
        }
    };

    public void btnAdminLogout(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

}