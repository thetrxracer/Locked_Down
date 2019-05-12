package com.example.lockeddown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SensorActivity extends AppCompatActivity {
    private TextView mTemp;
    private TextView mPressure;
    private TextView mHumidity;
    private TextView mDisplayTemp;
    private TextView mDisplayHumidity;
    private TextView mDisplayPressure;
    private Button mUpdate;
    DatabaseReference rtRef, childRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        mTemp = (TextView) findViewById(R.id.Temperature);
        mHumidity = (TextView) findViewById(R.id.humidity);
        mDisplayHumidity = (TextView) findViewById(R.id.HumidityDisplay);
        mDisplayPressure = (TextView) findViewById(R.id.PressureDisplay);
        mDisplayTemp = (TextView) findViewById(R.id.TempDisplay);
        mUpdate = (Button) findViewById(R.id.btnUpdate);

        rtRef = FirebaseDatabase.getInstance().getReference();

        childRef = rtRef.child("Sensor");



                mUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        childRef.child("Humidity").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String humidity = dataSnapshot.getValue(Long.class).toString();
                                mDisplayHumidity.setText(humidity);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        childRef.child("Temperature").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String temperature = dataSnapshot.getValue(Long.class).toString();
                                mDisplayTemp.setText(temperature);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        childRef.child("Pressure").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String pressure = dataSnapshot.getValue(Long.class).toString();
                                mDisplayPressure.setText(pressure);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    }
                });

    }

}
