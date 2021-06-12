package com.example.free_space;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Worker extends AppCompatActivity {
    private ListView WorkerList;
    private ArrayList<WorkerItem> arrayList;
    private EditText Name;
    private EditText Room;
    FirebaseDatabase database;
    DatabaseReference myRef;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        this.userId = pref.getString("user_id", null); // getting String
        Toast.makeText(Worker.this, userId, Toast.LENGTH_LONG).show();

        Name=findViewById(R.id.SerchWorkerName);
        Room=findViewById(R.id.RoomNum);
        WorkerList=findViewById(R.id.WorkerList);
        this.arrayList = new ArrayList<WorkerItem>();

        getWorkerData();
        WorkerAdapter wa=new WorkerAdapter(this,R.layout.worker_item, arrayList,false);
        WorkerList.setAdapter(wa);
    }

    public void btnWorkerLogout(View view) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        editor.clear(); // remove user id
        editor.commit(); // commit changes

        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void getWorkerData() {
        Query q = this.myRef.child("Workers").orderByValue();

        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int buildingNumber = 0;
                for(DataSnapshot dst: dataSnapshot.getChildren())
                {
                    if(String.valueOf(dst.getKey()).equals(userId)) {
                        WorkerItem temp = dst.getValue(WorkerItem.class);
                        assert temp != null;
                        buildingNumber = temp.getBuildingNum();
                    }
                }

                for(DataSnapshot dst: dataSnapshot.getChildren())
                {
                    WorkerItem temp = dst.getValue(WorkerItem.class);
                    assert temp != null;
                    if (temp.getBuildingNum() == buildingNumber){
                        arrayList.add(temp);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
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

    public void SearchAll(View view) {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        Query q =myRef.child("workers").orderByValue();
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= snapshot.getValue(String.class);

                Toast.makeText(Worker.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
