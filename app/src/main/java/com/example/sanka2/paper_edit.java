package com.example.sanka2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sanka2.databasesank.BDhandlerppr;
import com.example.sanka2.databasesank.DBhandlers;

import java.util.List;

public class paper_edit extends AppCompatActivity {

    Button btnpprsearch,btnpprupdate,btnpprdelete,btnnewinsert;
    EditText ppreditid,ppreditlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper_edit);

        ppreditid =findViewById(R.id.txt_edit_pprID);
        ppreditlink =findViewById(R.id.txt_edit_pprlink);

        btnpprsearch =findViewById(R.id.btn_edit_pprsearch);
        btnpprupdate =findViewById(R.id.btn_edit_ppr_update);
        btnpprdelete =findViewById(R.id.btn_edit_pprdelete);
        btnnewinsert=findViewById(R.id.btn_new_insert);

        btnpprsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BDhandlerppr BDhandlerppr = new BDhandlerppr(getApplicationContext());
                List user = BDhandlerppr.readAllInfo(ppreditid.getText().toString());

                if(user.isEmpty()){
                    Toast.makeText(paper_edit.this, "No Paper", Toast.LENGTH_SHORT).show();
                    ppreditid.setText(null);
                }
                else{
                    Toast.makeText(paper_edit.this, "Paper Found! Paper" +user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    ppreditid.setText(user.get(0).toString());
                    ppreditlink.setText(user.get(1).toString());


                }
            }
        });

        btnpprupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BDhandlerppr BDhandlerppr = new BDhandlerppr(getApplicationContext());
                Boolean status = BDhandlerppr.updateInfo(ppreditid.getText().toString(),ppreditlink.getText().toString());
                if (status){
                    Toast.makeText(paper_edit.this, "Paper Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(paper_edit.this, "Update Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnpprdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BDhandlerppr BDhandlerppr = new BDhandlerppr(getApplicationContext());
                BDhandlerppr.deleteInfo(ppreditid.getText().toString());

                Toast.makeText(paper_edit.this, "paper Deleted!", Toast.LENGTH_SHORT).show();
            }
        });

        btnnewinsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w1 =new Intent(getApplicationContext(),paper_insert.class);
                startActivity(w1);
            }
        });
    }
}