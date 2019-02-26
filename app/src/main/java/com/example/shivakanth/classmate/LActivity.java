package com.example.shivakanth.classmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText user,pass;
    Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l);
        mAuth = FirebaseAuth.getInstance();

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        log = findViewById(R.id.log);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = user.getText().toString();
                String p = pass.getText().toString();

                if(u.equals("admin") && p.equals("admin"))
                {
                    Intent intent = new Intent(LActivity.this,AdminActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LActivity.this, "Invalid Credentials. Try Again.", Toast.LENGTH_SHORT).show();
                    user.setText("");
                    pass.setText("");
                }
            }
        });
    }
}
