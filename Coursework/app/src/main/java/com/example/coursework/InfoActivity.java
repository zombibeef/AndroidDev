package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        //set up shared preferences
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        final String display = preferences.getString("display", "");

        TextView displayInfo = (TextView) findViewById(R.id.textViewName);
        displayInfo.setText(display);

        final Button btnContinue = findViewById(R.id.btnContinue);

        //continuation button with welcome pop up
        btnContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //to ensure the user can't go any further without a valid username
                if(display.equals("Username or Password Incorrect.")) {
                    //sends user back to register page
                    Toast.makeText(InfoActivity.this, "Please create a valid account", Toast.LENGTH_SHORT).show();
                    Intent regback = new Intent(InfoActivity.this, RegistrationActivity.class);
                    startActivity(regback);

                } else {
                    //grant access to the main application
                    Toast.makeText(InfoActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(InfoActivity.this, HomeActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
