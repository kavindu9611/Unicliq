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

public class paper_insert extends AppCompatActivity {

    EditText txtpprid,txtpprlink;
    Button btnppinsert,pprupdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper_insert);

        txtpprid =findViewById(R.id.txtpprname);
        txtpprlink =findViewById(R.id.txtpprlink);
        btnppinsert =findViewById(R.id.btn_ppr_insert);
        pprupdate =findViewById(R.id.btn_update);

        btnppinsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BDhandlerppr BDhandlerppr = new BDhandlerppr(getApplicationContext());
                Long newID = BDhandlerppr.addInfo(txtpprid.getText().toString(),txtpprlink.getText().toString());
                Toast.makeText(paper_insert.this, "Paper Insert. Paper Id:" + newID, Toast.LENGTH_SHORT).show();

                Intent i =new Intent(getApplicationContext(),paper_edit.class);
                startActivity(i);
            }

        });

        pprupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 =new Intent(getApplicationContext(),paper_edit.class);
                startActivity(i1);
            }
        });


    }
}