package com.example.coursework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //assign variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set home page
        bottomNavigationView.setSelectedItemId(R.id.home);

        //perform itemselectlistener to set up nav bar
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        overridePendingTransition(0, 0);
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
                        startActivity(new Intent(getApplicationContext()
                                , TourOverActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


        final Button Address = findViewById(R.id.SubmitAddresses);

        Address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Address = new Intent(HomeActivity.this, MapsActivity.class);
                startActivity(Address);
                finish();
            }
        });
    }
}
