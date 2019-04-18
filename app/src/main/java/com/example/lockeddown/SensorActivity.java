package com.example.lockeddown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class SensorActivity extends AppCompatActivity {
    private TextView mTemp;
    private TextView mPressure;
    private TextView mHumidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        mTemp = (TextView) findViewById(R.id.Temperature);
        mHumidity = (TextView) findViewById(R.id.humidity);
        mPressure = (TextView) findViewById(R.id.Pressure);


    }
}
