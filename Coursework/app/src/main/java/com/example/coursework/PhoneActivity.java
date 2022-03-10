package com.example.coursework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PhoneActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private EditText textEditNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        //assign variables
        textEditNumber = findViewById(R.id.numberedit);
        ImageView imageCallFunction = findViewById(R.id.callfunction);

        imageCallFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });


        ImageView DundeeCab = findViewById(R.id.callDundee);
        DundeeCab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 123456789"));
                if (ActivityCompat.checkSelfPermission(PhoneActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });


        ImageView glasgowCab = findViewById(R.id.callGlasgow);
        glasgowCab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 987654321"));
                if (ActivityCompat.checkSelfPermission(PhoneActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });

        final Button backbtn = findViewById(R.id.phonebackbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backbtn = new Intent(PhoneActivity.this, TourOverActivity.class);
                startActivity(backbtn);
                finish();
            }
        });
    }

    private void makeCall() {
        //contains number in string format
        String phonenumber = textEditNumber.getText().toString();
        //removes empty spaces at the beginning and end of number
        if (phonenumber.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(PhoneActivity.this,
                    //pass the permission
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                //requesting permission
                ActivityCompat.requestPermissions(PhoneActivity.this,
                        new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                //making phone call
                String dial = "tel: " + phonenumber;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            //if nothing typed into field display pop up
            Toast.makeText(PhoneActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

    private void dundeeCab() {
        //removes empty spaces at the beginning and end of number
            if (ContextCompat.checkSelfPermission(PhoneActivity.this,
                    //pass the permission
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                //requesting permission
                ActivityCompat.requestPermissions(PhoneActivity.this,
                        new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                //making phone call
                String dial = "tel: 123456789" ;
            }
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            //permitting access
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makeCall();
            } else {
                //access denied
                Toast.makeText(PhoneActivity.this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
