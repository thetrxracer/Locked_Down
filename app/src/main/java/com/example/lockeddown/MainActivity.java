package com.example.lockeddown;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lockeddown.R;
import com.google.android.gms.common.util.Base64Utils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private Button mUser_Management;
    private Button mSubmit;
    private DatabaseReference mFirebase;
    private EditText mEmail_Login;
    private EditText mPassword_Login;
    private FirebaseAuth mAuth;
    private Button mSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUser_Management = (Button) findViewById(R.id.User_Management);
        mUser_Management.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Moving to User Management", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, UserActivity.class);
                startActivity(i);
            }
        });

        mSubmit = (Button) findViewById(R.id.submit_button);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Submission pending", Toast.LENGTH_SHORT).show();
            }
        });

        mEmail_Login = (EditText) findViewById(R.id.email_login);
        mPassword_Login = (EditText) findViewById(R.id.password_login);
        mAuth = FirebaseAuth.getInstance();

        mSensor = (Button) findViewById(R.id.sensor_button);
        mSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Moving to Sensor page", Toast.LENGTH_SHORT).show();
                Intent j = new Intent(MainActivity.this, SensorActivity.class);
                startActivity(j);
            }
        });
    }


    private void updateUI(FirebaseUser currentUser) {

    }
    ///mFirebase = FirebaseDatabase.getInstance().getReference();


    }


