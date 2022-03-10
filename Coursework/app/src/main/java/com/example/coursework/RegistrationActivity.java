package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final EditText setuserName = (EditText) findViewById(R.id.regNewName);
        final EditText setpassword = (EditText) findViewById(R.id.regNewPassword);
        final EditText setemail = (EditText) findViewById(R.id.regNewEmail);
        Button btnRegister = (Button) findViewById(R.id.regNewRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //assign variables
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUser = setuserName.getText().toString();
                String newPassword = setpassword.getText().toString();
                String newEmail = setemail.getText().toString();

                //edit shared preferences
                SharedPreferences.Editor editor = preferences.edit();

                //login key - shared preferences will save here when register btn clicked
                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail);
                editor.commit();

                //sends back to login screen
                Intent loginScreen = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(loginScreen);
            }
        });

        final Button loginbackbtn = findViewById(R.id.loginback);

        //back button to access orignial login page
        loginbackbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
