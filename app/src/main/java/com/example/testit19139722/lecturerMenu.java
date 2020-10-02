package com.example.testit19139722;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lecturerMenu extends AppCompatActivity {

    Button library,notification,supportServices,loginReg,edit,proManage,logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_menu);

        library.findViewById(R.id.menuLib);
        notification.findViewById(R.id.menNot);
        supportServices.findViewById(R.id.menSupp);
        loginReg.findViewById(R.id.menLogReg);
        edit.findViewById(R.id.menEd);
        proManage.findViewById(R.id.menPR);
        logOut.findViewById(R.id.menLOG);

        loginReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Home.class);
                startActivity(i);
            }
        });

    }
}