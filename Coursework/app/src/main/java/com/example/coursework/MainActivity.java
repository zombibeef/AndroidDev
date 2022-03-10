package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public String user = "";
    String password;
    public static String userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText loginName = (EditText) findViewById(R.id.loginName);
        final EditText loginPassword = (EditText) findViewById(R.id.loginPassword);
        Button loginbtnLogin = (Button) findViewById(R.id.loginButton);
        Button loginbtnRegister = (Button) findViewById(R.id.regButton);



        //login button onclicklistener
        loginbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //assign variables
                user = loginName.getText().toString();
                userPass = loginName.getText().toString();
                password = loginPassword.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);

                //loading previously stored preferences
                String userDetails = preferences.getString(getUser() + password + "data", "Username or Password Incorrect.");
                //opening previously stored preferences
                SharedPreferences.Editor editor = preferences.edit();
                //displaying contents of preference
                editor.putString("display",userDetails);
                editor.commit();


                Intent displayScreen = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(displayScreen);
            }
        });


        //registration button onclicklistener
        loginbtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sends to registration page
                Intent registrationScreen = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(registrationScreen);
            }
        });

    }

    public static String getUser() {
        return userPass;
    }
}
