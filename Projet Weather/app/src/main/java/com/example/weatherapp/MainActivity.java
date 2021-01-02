package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button buttonGrandeVille, buttonMonuments, buttonAgenda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initbutton();

        buttonMonuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listeMonuments = new Intent(getApplicationContext(), MonumentsActivity.class);
                startActivity(listeMonuments);
            }
        });

        buttonGrandeVille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listeGrandeVille = new Intent(getApplicationContext(), GrandeVilleActivity.class);
                startActivity(listeGrandeVille);
            }
        });

        buttonAgenda.setOnClickListener((v)-> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("content://com.android.calendar/time")));
        });
    }

    private void initbutton() {
        buttonGrandeVille = findViewById(R.id.btGrandesVilles);
        buttonAgenda = findViewById(R.id.btAgenda);
        buttonMonuments = findViewById(R.id.btMonuments);
    }
}