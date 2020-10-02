package com.example.madcustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madcustomer.Database.DBHandler;

public class SupportServices extends AppCompatActivity {

    EditText username, subject, problem;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_services);

        username = findViewById(R.id.SS1);
        subject = findViewById(R.id.SS2);
        problem = findViewById(R.id.SS3);
        submit = findViewById(R.id.btnss);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                if (dbHandler.loginuser(username.getText().toString(), subject.getText().toString())) {
                    Toast.makeText(SupportServices.this, "Your Problem Sended!", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(), StudentProfile.class);
                    startActivity(i);

                } else {
                    Toast.makeText(SupportServices.this, "Failed !", Toast.LENGTH_SHORT).show();
                    username.setText(null);
                    subject.setText(null);

                }
            }
        });
    }
}