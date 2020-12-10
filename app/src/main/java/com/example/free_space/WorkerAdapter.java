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
    public WorkerAdapter(@NonNull Context context, int resource, @NonNull List<WorkerItem> objects) {
        super(context, resource, objects);
    }

    public int getcount(){
        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater li=(LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v =li.inflate(this.WorkerResourcedID, null);
        WorkerItem wi=this.data.get(position);
        TextView tv1=v.findViewById(R.id.WorkerNameItem);
        tv1.setText(wi.getName());
        TextView tv2=v.findViewById(R.id.NumberRoomItem);
        tv2.setText(wi.getName());
        TextView tv3=v.findViewById(R.id.EmailItem);
        tv3.setText(wi.getName());
        return  v;
    }
}
