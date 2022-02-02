package com.example.listview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DishAdapter extends ArrayAdapter<Dish> {
    private Context ct;
    private ArrayList<Dish> arr;
    public DishAdapter(@NonNull Context context, int resource, @NonNull List<Dish> objects) {
        super(context, resource, objects);
        this.ct=context;
        this.arr=new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            LayoutInflater i=(LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=i.inflate(R.layout.layout,null);
        }
    if (arr.size()>0){
        Dish d=arr.get(position);
        TextView txNameDish=convertView.findViewById(R.id.nametext);
        TextView txNumItem=convertView.findViewById(R.id.coursetext);
        txNameDish.setText(d.name);
        txNumItem.setText(d.course);
    }
    return convertView;
    }
}
