package com.example.shivakanth.classmate;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    List<tempClass> t = new ArrayList<>();
    List<String[]> time= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        String temptime[][] = {{"8:30am","9:20am"},{"9:20am","10:10am"},{"10:30am","11:20am"},{"11:20am","12:10pm"},{"1:30pm","2:20pm"},{"2:20pm","3:10pm"},{"3:30pm","4:20pm"},{"4:20pm","5:10pm"}};

        for(String[] t1: temptime){
            time.add(t1);
        }

        //test();
        viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

    void test()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dRef = database.getReference();
        DatabaseReference tt = dRef.child("tt");
        DatabaseReference classes = dRef.child("classes");


        classes.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot Snapshot: dataSnapshot.getChildren()) {
                    t.add(Snapshot.getValue(tempClass.class));
                }
                test2();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ClassActivity.this, "Unable to load classes.", Toast.LENGTH_SHORT).show();
            }
        });



    }

    void test2()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dRef = database.getReference();
        DatabaseReference tt = dRef.child("tt");
        DatabaseReference classes = dRef.child("classes");
        String days[] = {"mon", "tue", "wed", "thur", "fri"};

        for(int i =0; i<5; ++i)
        {
            Class testClass = new Class(t.get(0), time.get(0));
            DatabaseReference pusher = tt.child(days[i]);
            pusher.push().setValue(testClass);
            testClass = new Class(t.get(1), time.get(1));
            pusher.push().setValue(testClass);
            testClass = new Class(t.get(2), time.get(2));
            pusher.push().setValue(testClass);
        }
    }
}
