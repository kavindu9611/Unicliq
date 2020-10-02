package com.ccsl.android_tutorial_24_sqlite_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import android.widget.Toast;



import java.util.List;

public class EditProfile extends AppCompatActivity {

    EditText username, phone, address, contactno, email, password;
    Button edit, delete, search;
    RadioButton male,female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        username = findViewById(R.id.etUserNameEP);
        phone = findViewById(R.id.etPhoneEP);
        address = findViewById(R.id.etAddressEP);
        contactno = findViewById(R.id.etContactNoEP);
        email = findViewById(R.id.etEmailEP);
        password = findViewById(R.id.editTextGrade);
        edit = findViewById(R.id.btnEditEP);
        delete = findViewById(R.id.btnDeleteEP);
        search = findViewById(R.id.btnSearchEP);
        male = findViewById(R.id.radioButton);
        female = findViewById(R.id.radioButton2);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler1 dbHandler = new DBHandler1(getApplicationContext());
                List user = dbHandler.readAllInfo(username.getText().toString());

                if(user.isEmpty()){
                    Toast.makeText(EditProfile.this, "No User", Toast.LENGTH_SHORT).show();
                    username.setText(null);
                }
                else{
                    Toast.makeText(EditProfile.this, "User Found! User" +user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    username.setText(user.get(0).toString());
                    phone.setText(user.get(1).toString());
                    address.setText(user.get(2).toString());
                    contactno.setText(user.get(3).toString());
                    email.setText(user.get(4).toString());
                    password.setText(user.get(5).toString());

                    if(user.get(6).toString().equals("Male")){

                        male.setChecked(true);
                    }
                    else{
                        female.setChecked(true);
                    }

                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked()){
                    gender = "Male";

                }
                else{
                    gender = "Female";
                }
                DBHandler1 dbHandler = new DBHandler1(getApplicationContext());
                Boolean status = dbHandler.updateInfo(username.getText().toString(),phone.getText().toString(),address.getText().toString(),contactno.getText().toString(),email.getText().toString(),password.getText().toString(),gender);
                if (status){
                    Toast.makeText(EditProfile.this, "User Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(EditProfile.this, "Update Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHandler1 dbHandler = new DBHandler1(getApplicationContext());
                dbHandler.deleteInfo(username.getText().toString());

                Toast.makeText(EditProfile.this, "User Deleted!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}