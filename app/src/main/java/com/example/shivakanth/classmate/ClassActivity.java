package com.example.shivakanth.classmate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ClassActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Class> CList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        recyclerView = (RecyclerView) findViewById(R.id.classList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ClassAdapter(CList);
        recyclerView.setAdapter(mAdapter);

        createDummyClass();
    }

    void createDummyClass()
    {
        Class c = new Class("Analog Signal Processing","ICPC16","Dr. S. Narayanan","10:30am","11:20am");
        CList.add(c);

        c = new Class("Analog Signal Processing","ICPC16","Dr. S. Narayanan","10:30am","11:20am");
        CList.add(c);

        c = new Class("Analog Signal Processing","ICPC16","Dr. S. Narayanan","10:30am","11:20am");
        CList.add(c);

        c = new Class("Analog Signal Processing","ICPC16","Dr. S. Narayanan","10:30am","11:20am");
        CList.add(c);

        mAdapter.notifyDataSetChanged();

    }
}
