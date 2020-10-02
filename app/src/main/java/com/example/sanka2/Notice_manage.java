package com.example.sanka2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.sanka2.databasesank.DBhandlers;

public class Notice_manage extends AppCompatActivity {



    EditText tfnoteID,tfnote;
    Button btncreate, btnupdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_manage);

        tfnoteID = findViewById(R.id.txf1);
        tfnote = findViewById(R.id.txf2);

        btncreate = findViewById(R.id.btn_create);
        btnupdate = findViewById(R.id.btrn_update);


        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Notice_edit.class);
                startActivity(i);
            }
        });

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBhandlers DBhandlers = new DBhandlers(getApplicationContext());
                Long newID = DBhandlers.addInfo(tfnoteID.getText().toString(),tfnote.getText().toString());
                Toast.makeText(Notice_manage.this, "User Added. User Id:" + newID, Toast.LENGTH_SHORT).show();

                Intent i =new Intent(getApplicationContext(),Notice_edit.class);
                startActivity(i);

            }
        });

    }
}