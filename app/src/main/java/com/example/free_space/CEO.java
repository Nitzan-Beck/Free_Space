package com.example.free_space;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class CEO extends AppCompatActivity {
    private ListView WorkerList;
    private ArrayList<WorkerItem> arrayList;
    private EditText Name;

    Button btnLookAs;
    String[] s={"look as worker", "Look as boss"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_e_o);
        Name=findViewById(R.id.CEOSerchWorker);
        this.arrayList = new ArrayList<WorkerItem>();
        WorkerList=findViewById(R.id.ListViewFromCEO);
        getWrokerData();
        WorkerAdapter wa=new WorkerAdapter(this,R.layout.worker_item, arrayList);
        WorkerList.setAdapter(wa);

        btnLookAs=findViewById(R.id.LookAs);
        btnLookAs.setOnClickListener(btnLookAsListener);
    }
    private View.OnClickListener btnLookAsListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ArrayAdapter a=new ArrayAdapter(CEO.this,android.R.layout.simple_list_item_1,s);
            AlertDialog.Builder adb= new AlertDialog.Builder(CEO.this);
            adb.setTitle("Look as:");
            adb.setAdapter(a, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    if(s[i].equals("look as worker")){
                        Intent j=new Intent(CEO.this,Worker.class);
                        startActivity(j);
                    }
                    if (s[i].equals("Look as boss")){
                        Intent j=new Intent(CEO.this,Boss.class);
                        startActivity(j);
                    }
                }
            });
            adb.create().show();
        }
    };

    public void btnCEOLogout(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void getWrokerData() {
        WorkerItem wi = new WorkerItem("name1", 1, "Email1");
        arrayList.add(wi);
        wi = new WorkerItem("name2", 2, "Email2");
        arrayList.add(wi);
    }
    public void Cerch(View view) {

    }
}