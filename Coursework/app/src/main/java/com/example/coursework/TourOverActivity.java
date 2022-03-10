package com.example.coursework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TourOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        //assign variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set help selected
        bottomNavigationView.setSelectedItemId(R.id.help);

        //perform itemselectlistener to set up nav bar
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.notes:
                        startActivity(new Intent(getApplicationContext()
                                , NotesActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.weather:
                        startActivity(new Intent(getApplicationContext()
                                ,WeatherActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.help:
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        //internet browser button
        final Button browserbtn = findViewById(R.id.browserbtn);

        //button to browser function
        browserbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(TourOverActivity.this, BrowserActivity.class);
                startActivity(i);
                finish();
            }
        });

        //telephone button
        final Button telephonebtn = findViewById(R.id.callbtn);

        //button to telephone function
        telephonebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(TourOverActivity.this, PhoneActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
