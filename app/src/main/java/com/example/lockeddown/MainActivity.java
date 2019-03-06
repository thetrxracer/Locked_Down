package com.example.lockeddown;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lockeddown.R;
import com.google.android.gms.common.util.Base64Utils;

public class MainActivity extends AppCompatActivity {


    private Button mUser_Management;
    private Button mSensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUser_Management = (Button) findViewById(R.id.User_Management);
        mUser_Management.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, UserActivity.class);
                startActivity(i);
            }
        });
        mSensors = (Button) findViewById(R.id.Sensor_Page);


    }
}

