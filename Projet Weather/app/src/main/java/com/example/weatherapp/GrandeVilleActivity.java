package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class GrandeVilleActivity extends AppCompatActivity {
    private Spinner spinnerVilles;
    private GrandeVilleActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = GrandeVilleActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view;

        initializeVilles();
    }

    private void initializeVilles() {
        ArrayList<Ville> villes = new ArrayList<>();
        villes.add(new Ville("Chat"));
        villes.add(new Ville("Chien"));

        ArrayAdapter<Ville> VilleArrayAdapter = new ArrayAdapter<Ville>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, villes);
        VilleArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerVilles.setAdapter(VilleArrayAdapter);
    }
}