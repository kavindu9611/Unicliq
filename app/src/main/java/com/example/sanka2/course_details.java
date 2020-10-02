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

public class course_details extends AppCompatActivity {

    EditText course1,course2,course3,course4;
    RadioButton Rpass,Rfail;
    Button btncreate;
    String requ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        course1 = findViewById(R.id.txt_course_1);
        course2 = findViewById(R.id.txt_course_2);
        course3 = findViewById(R.id.txt_course_3);
        course4 = findViewById(R.id.txt_course_4);
        Rpass = findViewById(R.id.rd_course1);
        Rfail=findViewById(R.id.rd_course2);
        btncreate=findViewById(R.id.btn_course_submit);

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Rpass.isChecked()){
                    requ = "pass";

                }
                else{
                    requ = "faile";
                }
                DBhandlercourse DBhandlercourse = new DBhandlercourse(getApplicationContext());
                Long newID = DBhandlercourse.addInfo(course1.getText().toString(),course2.getText().toString(),course3.getText().toString(),course4.getText().toString(),requ);
                Toast.makeText(course_details.this, "Course Added. course Id:" + newID, Toast.LENGTH_SHORT).show();

                Intent i =new Intent(getApplicationContext(),course_details_edit.class);
                startActivity(i);
            }
        });
    }

}