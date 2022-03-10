package com.example.coursework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class NotesActivity extends AppCompatActivity {

    String User = MainActivity.getUser();

    String filename = User + ".txt";

    EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        edit_text = findViewById(R.id.textedit);

        //Navigation Bar - assign variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set notes selected
        bottomNavigationView.setSelectedItemId(R.id.notes);
        

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
                    case R.id.weather:
                        startActivity(new Intent(getApplicationContext()
                                ,WeatherActivity.class));
                        overridePendingTransition(0, 0);
                    case R.id.notes:
                        overridePendingTransition(0, 0);
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

    }

    //setting up save button
    public void savebtn(View V){
        String text = edit_text.getText().toString();
        FileOutputStream fileoutput = null;

        try{
            fileoutput = openFileOutput(filename, MODE_PRIVATE);
            fileoutput.write(text.getBytes());

            edit_text.getText().clear();
            //display popup with file directory
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + filename, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileoutput != null) {
                try {
                    fileoutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    //setting up load button
    public void loadbtn(View v){
        FileInputStream fileinput = null;


        //builds string
        try {
            fileinput = openFileInput(filename);
            InputStreamReader inStreamRead = new InputStreamReader(fileinput);
            BufferedReader buffread = new BufferedReader(inStreamRead);
            StringBuilder stringbuild = new StringBuilder();
            String text;

            while ((text = buffread.readLine()) != null) {
                stringbuild.append(text).append("\n");
            }

            edit_text.setText(stringbuild.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileinput != null) {
                try {
                    fileinput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
