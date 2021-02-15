package com.example.free_space;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.free_space.R;
import com.example.free_space.WorkerItem;

import java.util.List;

public class WorkerAdapter extends ArrayAdapter<WorkerItem> {

    private Context ctx;
    private int WorkerResourcedID;
    private List<WorkerItem> data;
    public WorkerAdapter( Context context, int resource,  List<WorkerItem> objects,boolean src) {
        //if src=falls it is worker else it is CEO
        super(context, resource, objects);
        if (src) {
            this.ctx=(CEO)context;
        }
        else {
            this.ctx=(Worker)context;
        }
        this.WorkerResourcedID=resource;
        this.data=objects;
    }
    @Override
    public int getCount(){ return data.size();}
    
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater li=(LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v =li.inflate(this.WorkerResourcedID, null);
        WorkerItem wi=this.data.get(position);
        TextView tv1=v.findViewById(R.id.WorkerNameItem);
        String s1="Worker name: "+wi.getName();
        tv1.setText(s1);
        TextView tv2=v.findViewById(R.id.NumberRoomItem);
        String s2="Worker's room number: "+wi.getRoomNum();
        tv2.setText(s2);
        TextView tv3=v.findViewById(R.id.EmailItem);
        String s3="Worker's Email:  "+wi.getEmail();
        tv3.setText(s3);
        TextView tv4=v.findViewById(R.id.BuildingItem);
        String s4="Worker's Building:  "+wi.getBuildingNum();
        tv4.setText(s4);
        TextView tv5=v.findViewById(R.id.typeItem);
        String s5="Worker's type:  "+wi.gettype();
        tv5.setText(s5);
        return  v;
    }
}
