package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonGrandeVille, buttonMonuments, buttonAgenda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initbutton();

        buttonMonuments.setOnClickListener((v) -> {

        });

        buttonGrandeVille.setOnClickListener((v) -> {

        });

        buttonAgenda.setOnClickListener((v)-> {

        });
    }

    private void initbutton() {
        buttonGrandeVille = findViewById(R.id.btGrandesVilles);
        buttonAgenda = findViewById(R.id.btAgenda);
        buttonMonuments = findViewById(R.id.btMonuments);
    }
}