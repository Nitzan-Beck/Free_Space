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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class CEO extends AppCompatActivity {
    private ListView WorkerList;
    private ArrayList<WorkerItem> arrayList;
    private EditText Name;
    HashMap<String, Boolean> bMap=new HashMap<String, Boolean>();

    private Button btnLookAs;
    String[] s={"look as worker", "Look as boss"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_e_o);
        Name=findViewById(R.id.CEOSerchWorker);
        this.arrayList = new ArrayList<WorkerItem>();
        WorkerList=findViewById(R.id.ListViewFromCEO);
        getWrokerData();
        WorkerAdapter wa=new WorkerAdapter(this,R.layout.worker_item, arrayList,true);
        WorkerList.setAdapter(wa);

        btnLookAs=findViewById(R.id.LookAs);
        btnLookAs.setOnClickListener(btnLookAsListener);


        bMap.put("Building1",true);
        bMap.put("Building2",true);
        bMap.put("Building3",true);
        bMap.put("Building4",true);

    }
    //the action open Dialog and the user need to choose  witch view he wants to be in.
    private View.OnClickListener btnLookAsListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ArrayAdapter a=new ArrayAdapter(CEO.this,android.R.layout.simple_list_item_1,s);// build ArrayAdapter and it calls a
            AlertDialog.Builder adb= new AlertDialog.Builder(CEO.this);// build the AlertDialog and it calls adb
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
        WorkerItem wi = new WorkerItem("name1", 1, "Email1", 1,"Boss");
        arrayList.add(wi);
        wi = new WorkerItem("name2", 2, "Email2",2,"Worker");
        arrayList.add(wi);
        wi = new WorkerItem("name3", 3, "Email3",3,"Worker");
        arrayList.add(wi);
        wi = new WorkerItem("name4", 2, "Email4",4,"Boss");
        arrayList.add(wi);
    }
    //the action serch worker in the ListView
    public void Serch(View view) {
        boolean foundName=false;
        ArrayList<WorkerItem> temp=new ArrayList<WorkerItem>();
        ArrayList<WorkerItem> temp1=new ArrayList<WorkerItem>(this.arrayList);// copy of the arrayList
        String name =String.valueOf(Name.getText());
        if (!String.valueOf(Name.getText()).equals("")){
            for (int i=0; i<temp1.size();i++)
            {
                if (name.equals(temp1.get(i).getName()))
                {
                    temp.add(temp1.remove(i));
                    foundName=true;
                }
            }
                if(!foundName) {
                    Toast.makeText(this,"you search a name that not exists",Toast.LENGTH_LONG).show();
                }
        }
        else  {
            Toast.makeText(this,"you did not search anything",Toast.LENGTH_LONG).show();
        }

        WorkerAdapter wa=new WorkerAdapter(this,R.layout.worker_item, temp, true);// the 1st parameter is the context and it give the access to resources, the 2nd is layout and the 3rd is Data
        WorkerList.setAdapter(wa);

    }
    // the action build AlertDialog and the user can choose which building will be in the ListView
    public void ChooseBuilding(View view) {
        final String[] stArry= bMap.keySet().toArray(new String[0]);//נבנה על בסיס המפתחות של הדיאלוג
          boolean [] boolArry=new boolean[bMap.size()];// נבנה על בסיס הערכים הבוליאנים של המפתחות

        for (int i=0; i>stArry.length;i++)
        {
            boolArry[i]=bMap.get(stArry[i]);
        }
        AlertDialog.Builder BuildingList= new AlertDialog.Builder(this);
        BuildingList.setTitle("choose buildings");
        BuildingList.setMultiChoiceItems(stArry, boolArry, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bMap.put(stArry[which], isChecked);

            }
        });
        BuildingList.setPositiveButton("serch", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {//just for building 2 TBC
                ArrayList<WorkerItem> temp2=new ArrayList<WorkerItem>();
                WorkerItem wi = new WorkerItem("name2", 2, "Email2",2,"worker");
                temp2.add(wi);
                WorkerAdapter wa=new WorkerAdapter(CEO.this,R.layout.worker_item, temp2, true);// the 1st parameter is the context and it give the access to resources, the 2nd is layout and the 3rd is Data
                WorkerList.setAdapter(wa);
//                displayAllBuildings();
            }
        });
        BuildingList.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(CEO.this,"you didn't do anything",Toast.LENGTH_LONG).show();
            }
        });
        BuildingList.create().show();
    }
//    public void displayAllBuildings()
//    {
//        final String[] stArry=bMap.keySet().toArray(new String[0]);
//        for (int i=0; i< stArry.length;i++)
//        {
//            Toast.makeText(this,"/n"+stArry[i]+":"+bMap.get(stArry[i]),Toast.LENGTH_LONG).show();
//        }
//    }
}