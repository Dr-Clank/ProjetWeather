package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class ConseilActivity extends AppCompatActivity {
    private TextView textViewConseil, textViewTemperature, textViewHumidite;
    private ImageView imageViewConseil;
    private Ville maVille;
    private Monuments monMonument;
    private TextView textViewPrevisions;
    boolean ville = true;
    String phrase;
    double moyHumidity =0;
    double moyTemp=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conseil);
        Intent monIntent = getIntent();
        if((boolean)monIntent.getSerializableExtra("BOOLEAN"))
        {
            maVille = (Ville) monIntent.getSerializableExtra("VILLE_DETAIL");
        }
        else
        {
            ville = false;
            monMonument = (Monuments) monIntent.getSerializableExtra("MONUMENT_DETAIL");
        }
        String previsionUrl;
        String previsionUrlpart1= "https://api.openweathermap.org/data/2.5/forecast?";
        String URLCODE="951e6039b0125b7933eeb20c3cce4b4b";
        if(ville)
        {
            previsionUrl = previsionUrlpart1 + "q="+maVille.get_nom()+",FR&units=metric&appid="+ URLCODE;
        }
        else
        {
            previsionUrl = previsionUrlpart1+"lat="+monMonument.getLatitude()+"lon="+monMonument.getLongitude()+"&appid="+URLCODE;
        }

        final GsonRequest gsonRequest = new GsonRequest(previsionUrl, Previsions.class, null, new Response.Listener<Previsions>() {
            @Override
            public void onResponse(Previsions previsions) {
                phrase = previsions.getCity().getName() + "  " +previsions.getCity().getCountry()  + "\n";

                for (Prevision prevision : previsions.getPrevisions()) {
                    moyHumidity = moyHumidity+Double.parseDouble(prevision.getMain().getHumidity());
                    moyTemp = moyTemp+Double.parseDouble(prevision.getMain().getTemp());
                }
                moyHumidity = moyHumidity / previsions.getPrevisions().size();
                moyTemp = moyTemp / previsions.getPrevisions().size();
                init();

                /*
                if(moyHumidity>66)
                {
                    if(moyTemp>20)
                    {

                    }
                }else
                {
                    if(moyHumidity>33)
                    {

                    }
                    else
                    {

                    }
                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if(volleyError != null) Log.e("MainActivity", volleyError.getMessage());
            }
        });
        VolleyHelper.getInstance(getApplicationContext()).addToRequestQueue(gsonRequest);
    }

    private void init() {
        textViewConseil = findViewById(R.id.tvConseil);
        textViewHumidite = findViewById(R.id.tvHumidity);
        textViewTemperature = findViewById(R.id.tvTemp);
        imageViewConseil = findViewById(R.id.imageConseil);

        textViewHumidite.setText(String.valueOf(moyHumidity));
        textViewTemperature.setText(String.valueOf(moyTemp));
    }
}