package com.example.shivakanth.classmate;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TabFragment extends Fragment {

    int position;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Class> CList  = new ArrayList<>();

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");

        createDummyClass();
        loadClass();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.classList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);


        mAdapter = new ClassAdapter(CList);
        recyclerView.setAdapter(mAdapter);



    }
    void createDummyClass()
    {
        Class c = new Class("Analog Signal Processing","ICPC16","Dr. S. Narayanan","10:30am","11:20am");
        CList.add(c);

        /*Class d = new Class("Industrial Instrumentation","ICPC17","Dr. S. Narayanan","10:30am","11:20am");
        CList.add(d);

        Class e = new Class("Signals and Systems","ICPC18","Dr. S. Narayanan","10:30am","11:20am");
        CList.add(e);

        Class f = new Class("Numerical Methods","MAIR43","Dr. S. Narayanan","10:30am","11:20am");
        CList.add(f);
        */
    }

    void loadClass()
    {
        Class d = new Class("Industrial Instrumentation","ICPC17","Dr. S. Narayanan","10:30am","11:20am");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dRef = database.getReference();
        dRef.child("tt").child("fri").child("3").setValue(d);

    }


}