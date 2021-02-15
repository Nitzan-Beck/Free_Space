package com.example.free_space;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Worker extends AppCompatActivity {
   private ListView WorkerList;
    private ArrayList<WorkerItem> arrayList;
    private EditText Name;
    private EditText Room;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);
        Name=findViewById(R.id.SerchWorkerName);
        Room=findViewById(R.id.RoomNum);
        this.arrayList = new ArrayList<WorkerItem>();
        WorkerList=findViewById(R.id.WorkerList);
        getWorkerData();
        WorkerAdapter wa=new WorkerAdapter(this,R.layout.worker_item, arrayList,false);
        WorkerList.setAdapter(wa);
    }

    public void btnWorkerLogout(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);

        WorkerList=findViewById(R.id.WorkerList);

    }
    public void getWorkerData() {
        WorkerItem wi = new WorkerItem("name1", 1, "Email1",1,"Boss");
        arrayList.add(wi);
        wi = new WorkerItem("name2", 2, "Email2",2,"Worker");
        arrayList.add(wi);
        wi = new WorkerItem("name3", 3, "Email3",3,"Worker");
        arrayList.add(wi);
        wi = new WorkerItem("name4", 2, "Email4",4,"Boss");
        arrayList.add(wi);
    }

    public void SearchBtn(View view) {
        boolean foundName=false,foundroom=false;
        ArrayList<WorkerItem> temp=new ArrayList<WorkerItem>();
        ArrayList<WorkerItem> temp1=new ArrayList<WorkerItem>(this.arrayList);
        String name =String.valueOf(Name.getText());
        String room=String.valueOf(Room.getText());
        if (!String.valueOf(Name.getText()).equals("")){
            for (int i=0; i<temp1.size();i++)
            {
                if (name.equals(temp1.get(i).getName()))
                {
                    temp.add(temp1.remove(i));
                    foundName=true;
                }
            }
            if (!foundName){
                    Toast.makeText(this,"you search a name that not exists",Toast.LENGTH_LONG).show();
            }
        }
        if (!String.valueOf(Room.getText()).equals("")){
            for (int i=0; i<temp1.size();i++)
            {
                if (String.valueOf(Room.getText()).equals (String.valueOf(temp1.get(i).getRoomNum())))
                {
                    temp.add(temp1.remove(i));
                    foundroom=true;
                }
            }
                if(!foundroom) {
                    Toast.makeText(this,"you search a room number that not exists",Toast.LENGTH_LONG).show();
                }
        }
            if(String.valueOf(Room.getText()).equals("")&& String.valueOf(Name.getText()).equals("")) {
              Toast.makeText(this,"you did not search anything",Toast.LENGTH_LONG).show();
            }
            WorkerAdapter wa=new WorkerAdapter(this,R.layout.worker_item, temp, false);
            WorkerList.setAdapter(wa);
    }
}
