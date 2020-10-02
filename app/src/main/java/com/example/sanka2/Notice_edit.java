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

import java.util.List;

public class Notice_edit extends AppCompatActivity {

    EditText tfnoteID,tfnot;
    Button edit, delete, search,new_notice,btn_menu1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_edit);


        tfnoteID = findViewById(R.id.txtf3);
        tfnot = findViewById(R.id.txtf4);

        delete = findViewById(R.id.btn_romove);
        search = findViewById(R.id.btn_search);
        edit = findViewById(R.id.btn_upd);
        new_notice =findViewById(R.id.btn_notice_insertnew);
        btn_menu1=findViewById(R.id.btn_menu1);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhandlers DBhandlers = new DBhandlers(getApplicationContext());
                List user = DBhandlers.readAllInfo(tfnoteID.getText().toString());

                if(user.isEmpty()){
                    Toast.makeText(Notice_edit.this, "No Notice", Toast.LENGTH_SHORT).show();
                    tfnoteID.setText(null);
                }
                else{
                    Toast.makeText(Notice_edit.this, "Notice Found! Notice" +user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    tfnoteID.setText(user.get(0).toString());
                    tfnot.setText(user.get(1).toString());


                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBhandlers DBhandlers = new DBhandlers(getApplicationContext());
                Boolean status = DBhandlers.updateInfo(tfnoteID.getText().toString(),tfnot.getText().toString());
                if (status){
                    Toast.makeText(Notice_edit.this, "User Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Notice_edit.this, "Update Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBhandlers DBhandlers = new DBhandlers(getApplicationContext());
                DBhandlers.deleteInfo(tfnoteID.getText().toString());

                Toast.makeText(Notice_edit.this, "User Deleted!", Toast.LENGTH_SHORT).show();
            }
        });

        new_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent q =new Intent(getApplicationContext(),Notice_manage.class);
                startActivity(q);
            }
        });
        btn_menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent q1 =new Intent(getApplicationContext(),home1.class);
                startActivity(q1);
            }
        });
    }
}
