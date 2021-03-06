package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.databinding.ActivityGrandeVilleBinding;

import java.util.ArrayList;

public class GrandeVilleActivity extends AppCompatActivity {
    private Spinner spinnerVilles;
    private Button buttonAskAdvice;
    private ActivityGrandeVilleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGrandeVilleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initialize();

        buttonAskAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ville maVille = (Ville) spinnerVilles.getSelectedItem();
                Intent detail = new Intent(getApplicationContext(), ConseilActivity.class);
                detail.putExtra("VILLE_DETAIL", maVille);
                detail.putExtra("BOOLEAN", true);
                startActivity(detail);
            }
        });
    }

    private void initialize() {
        spinnerVilles = findViewById(R.id.spinnerVilles);
        buttonAskAdvice = findViewById(R.id.btGdVAskAdvice);

        ArrayList<Ville> villes = new ArrayList<>();
        villes.add(new Ville("Paris"));
        villes.add(new Ville("Marseille"));
        villes.add(new Ville("Lyon"));
        villes.add(new Ville("Toulouse"));
        villes.add(new Ville("Nice"));
        villes.add(new Ville("Nantes"));
        villes.add(new Ville("Montpellier"));
        villes.add(new Ville("Strasbourg"));
        villes.add(new Ville("Bordeaux"));
        villes.add(new Ville("Lille"));
        villes.add(new Ville("Rennes"));
        villes.add(new Ville("Reims"));
        villes.add(new Ville("Saint-Étienne"));
        villes.add(new Ville("Toulon"));
        villes.add(new Ville("Le Havre"));
        villes.add(new Ville("Grenoble"));
        villes.add(new Ville("Dijon"));
        villes.add(new Ville("Angers"));
        villes.add(new Ville("Nîmes"));
        villes.add(new Ville("Villeurbanne"));
        villes.add(new Ville("Clermont-Ferrand"));
        villes.add(new Ville("Le Mans"));
        villes.add(new Ville("Aix-en-Provence"));
        villes.add(new Ville("Brest"));
        villes.add(new Ville("Amiens"));
        villes.add(new Ville("Limoges"));
        villes.add(new Ville("Annecy"));
        villes.add(new Ville("Perpignan"));

        ArrayAdapter<Ville> VilleArrayAdapter = new ArrayAdapter<Ville>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, villes);
        VilleArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerVilles.setAdapter(VilleArrayAdapter);
    }
}