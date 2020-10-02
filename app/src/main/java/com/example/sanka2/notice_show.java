package com.example.sanka2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sanka2.databasesank.DBhandlers;

import java.util.List;

public class notice_show extends AppCompatActivity {

    Button bushow;
    EditText notID,not;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_show);

        bushow=findViewById(R.id.btn_show);
        notID = findViewById(R.id.txf_no_id);
        not = findViewById(R.id.txf_show);

        bushow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhandlers DBhandlers = new DBhandlers(getApplicationContext());
                List user = DBhandlers.readAllInfo(notID.getText().toString());

                if (user.isEmpty()) {
                    Toast.makeText(notice_show.this, "No Notice", Toast.LENGTH_SHORT).show();
                    notID.setText(null);
                } else {
                    Toast.makeText(notice_show.this, "Notice Found! Notice" + user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    notID.setText(user.get(0).toString());
                    not.setText(user.get(1).toString());

                }
            }
        });

}
}