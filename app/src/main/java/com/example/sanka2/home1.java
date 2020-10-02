package com.example.sanka2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home1 extends AppCompatActivity {

    Button binsert,bshow,btnpprinsert,btn_course_insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        binsert=findViewById(R.id.btn_not_insert);
        bshow=findViewById(R.id.btn_show1);
        btnpprinsert=findViewById(R.id.btn_ppr_home_insert);
        btn_course_insert=findViewById(R.id.course_isert);

        binsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),Notice_manage.class);
                startActivity(i1);
            }
        });
        bshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getApplicationContext(),notice_show.class);
                startActivity(i2);
            }
        });
        btnpprinsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getApplicationContext(),paper_insert.class);
                startActivity(i3);
            }
        });
        btn_course_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(getApplicationContext(),course_details.class);
                startActivity(i4);
            }
        });
    }
}