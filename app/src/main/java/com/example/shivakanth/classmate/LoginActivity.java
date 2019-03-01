package com.example.shivakanth.classmate;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    Button login, vC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.lButton);
        vC = findViewById(R.id.viewC);
        testfn();

        vC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(LoginActivity.this, ClassActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }
        });
    }

    void testfn()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dRef = database.getReference();
        dRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("TT Change")
                        .setContentText("There has been a change in the timetable")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManager mNotificationManager =

                        (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

                        mNotificationManager.notify(001, builder.build());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
