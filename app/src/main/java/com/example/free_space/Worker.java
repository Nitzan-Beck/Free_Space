package com.example.free_space;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Worker extends AppCompatActivity {
    ListView WorkerList;
    ArrayList<WorkerItem> arrayList=new ArrayList<WorkerItem>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);
        WorkerAdapter wa=new WorkerAdapter(this,R.layout.worker_item, arrayList);
        WorkerList.setAdapter(wa);
    }

    public void btnWorkerLogout(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);

        WorkerList=findViewById(R.id.WorkerList);
        getSonData();
    }
    public void getSonData() {
        WorkerItem wi = new WorkerItem("name1", 1, "Email1");
        arrayList.add(wi);
        wi = new WorkerItem("name2", 2, "Email2");
    }
}
