package com.example.lockeddown;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lockeddown.R;
import com.google.android.gms.common.util.Base64Utils;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private Button mUser_Management;
    private Button mSensors;
    private Button mSubmit;
    private DatabaseReference mFirebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUser_Management = (Button) findViewById(R.id.User_Management);
        mUser_Management.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, UserActivity.class);
                startActivity(i);
            }
        });

        mSensors = (Button) findViewById(R.id.Sensor_Page);
        mSubmit = (Button) findViewById(R.id.submit_button);
        mFirebase = FirebaseDatabase.getInstance().getReference();


    }
}

