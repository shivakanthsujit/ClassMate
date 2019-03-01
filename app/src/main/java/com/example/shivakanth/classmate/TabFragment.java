package com.example.shivakanth.classmate;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
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
    List<tempClass> t = new ArrayList<>();
    tempClass change = new tempClass();


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

        //createDummyClass();
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
        mAdapter.notifyDataSetChanged();
        listener();



    }

    void loadClass()
    {
        String days[] = {"mon","tue","wed","thur","fri"};
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dRef = database.getReference().child("tt").child(days[position]);


        dRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                CList.clear();
                for (DataSnapshot Snapshot: dataSnapshot.getChildren()) {
                    CList.add(Snapshot.getValue(Class.class));
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Unable to load classes.", Toast.LENGTH_SHORT).show();
            }
        });



    }

    void loadDaysClasses()
    {
        String days[] = {"mon","tue","wed","thur","fri"};
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dRef = database.getReference();
        dRef.child("tt").child(days[position]);

    }

    void listener()
    {
        String days[] = {"mon","tue","wed","thur","fri"};
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dRef = database.getReference().child("tt").child(days[position]);
        dRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Class newClass = dataSnapshot.getValue(Class.class);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                Class newClass = dataSnapshot.getValue(Class.class);
                Toast.makeText(getContext(), newClass.getName()+" has changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Class newClass = dataSnapshot.getValue(Class.class);
                Toast.makeText(getContext(), newClass.getName()+" has been deleted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        DatabaseReference classes = database.getReference().child("classes");

        classes.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                change = dataSnapshot.getValue(tempClass.class);
                //Toast.makeText(getActivity().getApplicationContext(), "Details Changed: "+change.getProf()+" "+change.getCode()+" "+change.getName(), Toast.LENGTH_SHORT).show();

                for (int i = 0;i<CList.size();++i)
                {
                    Toast.makeText(getActivity().getApplicationContext(), CList.get(i).getCode(), Toast.LENGTH_LONG).show();
                    if(CList.get(i).getName() == change.getName() || CList.get(i).getCode() == change.getCode() || CList.get(i).getProf() == change.getProf())
                    {
                        CList.get(i).changeDets(change);
                        Toast.makeText(getActivity().getApplicationContext(), CList.get(i).getName()+"hahahahahaha", Toast.LENGTH_SHORT).show();
                    }
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}

