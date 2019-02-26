package com.example.shivakanth.classmate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.MyViewHolder> {

    private List<Class> ClassList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, prof, code,time;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            code = (TextView) view.findViewById(R.id.code);
            prof = (TextView) view.findViewById(R.id.prof);
            time = (TextView) view.findViewById(R.id.time);
        }
    }


    public ClassAdapter(List<Class> ClasssList) {
        this.ClassList = ClasssList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.class_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Class Class = ClassList.get(position);
        holder.name.setText(Class.getName());
        holder.code.setText(Class.getCode());
        holder.prof.setText(Class.getProf());
        String t = Class.getStime();
        t+=" - "+Class.getEtime();
        holder.time.setText(t);
    }

    @Override
    public int getItemCount() {
        return ClassList.size();
    }
}