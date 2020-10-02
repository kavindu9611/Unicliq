package com.ccsl.android_tutorial_24_sqlite_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;



public class ProfileManagement extends AppCompatActivity {

    EditText username, phone, address, contactno, email, password;
    Button createprofile, updateprofile;
    RadioButton male,female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        username = findViewById(R.id.etExamID);
        phone = findViewById(R.id.etStRegNo);
        address = findViewById(R.id.etStName);
        contactno = findViewById(R.id.etStNic);
        email = findViewById(R.id.etModuleName);
        password = findViewById(R.id.etGrade);
        createprofile = findViewById(R.id.btnCreateP);
        updateprofile = findViewById(R.id.btnUpdateP);
        male = findViewById(R.id.radioButton3);
        female = findViewById(R.id.radioButton4);

        updateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),EditProfile.class);
                startActivity(i);
            }
        });

        createprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked()){
                    gender = "Male";

                }
                else{
                    gender = "Female";
                }
                DBHandler1 dbHandler = new DBHandler1(getApplicationContext());
                Long newID = dbHandler.addInfo(username.getText().toString(),phone.getText().toString(),address.getText().toString(),contactno.getText().toString(),email.getText().toString(),password.getText().toString(),gender);
                Toast.makeText(ProfileManagement.this, "Result Added. Exam Id:" + newID, Toast.LENGTH_SHORT).show();

                Intent i =new Intent(getApplicationContext(),EditProfile.class);
                startActivity(i);

            }
        });

    }

}