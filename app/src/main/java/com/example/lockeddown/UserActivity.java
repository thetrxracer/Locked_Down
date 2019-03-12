package com.example.lockeddown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class UserActivity extends AppCompatActivity {

    private Button mSubmit;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mPassword;
    private EditText mEmail;
    private TextView mViewFirst;
    private TextView mViewLast;
    private TextView mViewEmail;
    private TextView mViewPassword;
    private DatabaseReference mFirebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        mSubmit = (Button) findViewById(R.id.Press_to_Submit);

        mFirstName = (EditText) findViewById(R.id.Make_First_Name);
        mViewFirst = (TextView) findViewById(R.id.Make_First_Name); // so that we can see the text.

        mLastName = (EditText) findViewById(R.id.Make_Last_Name);
        mViewLast = (TextView) findViewById(R.id.Make_Last_Name); // so that we can see the text.

        mPassword = (EditText) findViewById(R.id.Make_Password);
        mViewPassword = (TextView) findViewById(R.id.Make_Password); // so that we can see the text.

        mEmail = (EditText) findViewById(R.id.Make_Email);
        mViewEmail = (TextView) findViewById(R.id.Make_Email); // so that we can see the text.

        mFirebase = FirebaseDatabase.getInstance().getReference();

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This adds the name to the database
                //Right now it sets the value to the string in the parenthesis
                //Next we will pass it a string to set in the database
                //string
                UUID uuid = UUID.randomUUID();  //Creates a random id
                String userId = uuid.toString();//turns the id into a string

                String first = mFirstName.getText().toString(); //turns the text into a string, to work with User class.
                String last = mLastName.getText().toString(); //turns the text into a string, to work with User class.
                String email = mEmail.getText().toString(); //turns the text into a string, to work with User class.
                String password = mPassword.getText().toString(); //turns the text into a string, to work with User class.

                mViewFirst.setText(first); //put the text string in a variable.
                mViewLast.setText(last); //put the text string in a variable.
                mViewEmail.setText(email); //put the text string in a variable.
                mViewPassword.setText(password); //put the text string in a variable.

                User user = new User(first, last, email, password);
                mFirebase.child("Users").child(userId).setValue(user);


            }
        });
    }
}

