package com.example.coursework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import android.content.Context;

import com.example.coursework.R;

public class RemoteFetch {


    //https://developer.android.com/reference/java/net/HttpURLConnection

    private static final String OPEN_WEATHER_MAP_API =
                "http://api.openweathermap.org/data/2.5/weather?q=Glasgow&units=metric&appid=3597bf9c34a0c4a936964eb61a98bb66";

    public static JSONObject getJSON(Context context, String city){
        try {
            URL url = new URL(String.format(OPEN_WEATHER_MAP_API));
            HttpURLConnection connection =
                    (HttpURLConnection)url.openConnection();


            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp="";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());

            /*
            if(data.getInt("cod") != 200){
                return null;
            }

             */

            return data;
        }catch(Exception e){
            return null;
        }
    }
}