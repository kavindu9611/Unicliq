package com.example.madcustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madcustomer.Database.DBHandler;

public class Feedback extends AppCompatActivity {

    EditText username,description;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        username = findViewById(R.id.usFD);
        description = findViewById(R.id.tyFD);
        add = findViewById(R.id.addFD);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                if (dbHandler.loginuser(username.getText().toString(), description.getText().toString())) {
                    Toast.makeText(Feedback.this, "Thanks For Your Feedback!", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(), StudentProfile.class);
                    startActivity(i);

                } else {
                    Toast.makeText(Feedback.this, "Failed !", Toast.LENGTH_SHORT).show();
                    username.setText(null);
                    description.setText(null);

                }
            }
        });

     }
    }
