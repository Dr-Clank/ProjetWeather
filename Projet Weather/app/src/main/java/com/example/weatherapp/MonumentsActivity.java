package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MonumentsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Monuments> dataMonuments;

    private RecyclerViewMonumentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monuments);

        recyclerView = findViewById(R.id.rvMonuments);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setFocusable(false);

        setDatas();

        adapter = new RecyclerViewMonumentAdapter(dataMonuments);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchMonumentListener(this, recyclerView, new RecyclerTouchMonumentListener() {
            @Override
            public void onClick(View view, int position) {
                Monuments monMonument = dataMonuments.get(position);
                Intent detail = new Intent(getApplicationContext(), DetailPatientActivity.class);
                detail.putExtra("PATIENT_DETAIL", monMonument);
                startActivity(detail);

            }
        }));
    }

    private void setDatas()
    {
        dataMonuments = new ArrayList<Monuments>();
    }
}