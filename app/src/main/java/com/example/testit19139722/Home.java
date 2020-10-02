package com.example.testit19139722;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testit19139722.database.DBHandler;

public class Home extends AppCompatActivity {

    EditText username,password;
    Button login,register;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       username = findViewById(R.id.etUserNameH);
       password = findViewById(R.id.etPasswordH);
       login = findViewById(R.id.btnLoginH);
       register = findViewById(R.id.btnRegisterH);
       context = this;

      register.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent i5 = new Intent(getApplicationContext(),lec_menu.class);
              startActivity(i5);
          }
      });



       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               DBHandler dbHandler = new DBHandler(getApplicationContext());

              if( dbHandler.loginUser(username.getText().toString(),password.getText().toString())){

                  Toast.makeText(Home.this, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();

                  Intent i = new Intent(getApplicationContext(),ProfileManagement.class);
                  startActivity(i);


              }
              else{

                  Toast.makeText(Home.this, "INVALID USER", Toast.LENGTH_SHORT).show();
                  username.setText(null);
                  password.setText(null);

              }
           }
       });

    }


}