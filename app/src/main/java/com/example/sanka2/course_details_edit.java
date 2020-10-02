package com.example.sanka2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.sanka2.databasesank.DBhandlercourse;
import com.example.sanka2.databasesank.DBhandlers;

import java.util.List;

public class course_details_edit extends AppCompatActivity {


    EditText coursee1,coursee2,coursee3,coursee4;
    RadioButton Rpasse1,Rpasse2;
    Button course_search,course_update,course_delete,btn_newisert;
    String requ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details_edit);

        coursee1 =findViewById(R.id.txt_course_edit1);
        coursee2 =findViewById(R.id.txt_course_edit2);
        coursee3 =findViewById(R.id.txt_course_edit3);
        coursee4 =findViewById(R.id.txt_course_edit4);
        Rpasse1 =findViewById(R.id.rd_course_edit1);
        Rpasse2 =findViewById(R.id.rd_course_edit2);
        course_search =findViewById(R.id.btn_course_edit_search);
        course_update =findViewById(R.id.btn_course_edit_update);
        course_delete =findViewById(R.id.btn_course_edit_delete);
        btn_newisert =findViewById(R.id.btn_new);

        course_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhandlercourse DBhandlercourse = new DBhandlercourse(getApplicationContext());
                List user = DBhandlercourse.readAllInfo(coursee1.getText().toString());

                if(user.isEmpty()){
                    Toast.makeText(course_details_edit.this, "No cousre", Toast.LENGTH_SHORT).show();
                    coursee1.setText(null);
                }
                else{
                    Toast.makeText(course_details_edit.this, "course Found! course" +user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    coursee1.setText(user.get(0).toString());
                    coursee2.setText(user.get(1).toString());
                    coursee3.setText(user.get(2).toString());
                    coursee4.setText(user.get(3).toString());

                    if(user.get(4).toString().equals("pass")){

                        Rpasse1.setChecked(true);
                    }
                    else{
                        Rpasse2.setChecked(true);
                    }


                }
            }
        });

        course_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Rpasse1.isChecked()){
                    requ = "pass";

                }
                else{
                    requ = "fail";
                }
                DBhandlercourse DBhandlercourse = new DBhandlercourse(getApplicationContext());
                Boolean status = DBhandlercourse.updateInfo(coursee1.getText().toString(),coursee2.getText().toString(),coursee3.getText().toString(),coursee4.getText().toString(),requ);
                if (status){
                    Toast.makeText(course_details_edit.this, "Course Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(course_details_edit.this, "Update Failed!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        course_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhandlercourse DBhandlercourse = new DBhandlercourse(getApplicationContext());
                DBhandlercourse.deleteInfo(coursee1.getText().toString());

                Toast.makeText(course_details_edit.this, "User Deleted!", Toast.LENGTH_SHORT).show();

            }
        });

        btn_newisert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l =new Intent(getApplicationContext(),course_details.class);
                startActivity(l);
            }
        });

    }
}