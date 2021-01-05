package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class ConseilActivity extends AppCompatActivity {
    private TextView textViewConseil, textViewTemperature, textViewHumidite;
    private ImageView imageViewConseil;
    private Button buttonAskAgenda;
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
        String URLCODE="&units=metric&appid=951e6039b0125b7933eeb20c3cce4b4b";

        init();

        buttonAskAgenda.setOnClickListener((v)-> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("content://com.android.calendar/time")));
        });

        if(ville)
        {
            previsionUrl = previsionUrlpart1 + "q="+maVille.get_nom()+",FR"+ URLCODE;
        }
        else
        {
            previsionUrl = previsionUrlpart1+"lat="+monMonument.getLatitude()+"&lon="+monMonument.getLongitude()+URLCODE;
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
                findTextAndImage();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if(volleyError != null) Log.e("MainActivity", volleyError.getMessage());
            }
        });
        VolleyHelper.getInstance(getApplicationContext()).addToRequestQueue(gsonRequest);

    }

    private void findTextAndImage() {
        String textToAdvice;
        String imageToDisplay;
        int humidityStatement =0;
        boolean tempStatement = false;
        textViewHumidite.setText(String.valueOf(String.format("%.2f", moyHumidity))+" %");
        textViewTemperature.setText(String.valueOf(String.format("%.2f", moyTemp)) +" °C");
        if(moyTemp>15) {
            tempStatement = true;
        }
        if(humidityStatement >=66)
        {
            humidityStatement = 2;
        }
        else
        {
            if(humidityStatement>=33)
            {
                humidityStatement =1;
            }
        }

        switch (humidityStatement)
        {
            case 2:
                if(tempStatement)
                {
                    imageViewConseil.setImageResource(R.drawable.parapluie);
                    textToAdvice = "Il fait chaud et c'est humide, je vous conseil de prendre un parabluie";
                }
                else
                {
                    imageViewConseil.setImageResource(R.drawable.impermeable);
                    textToAdvice = "Il fait froit et c'est humide, je vous conseil de prendre une impermeable chaud";
                }
                break;
            case 1:
                if(tempStatement)
                {
                    imageViewConseil.setImageResource(R.drawable.gilet);
                    textToAdvice = "Il fait chaud et un peu humide, je vous conseil de prendre un gilet";
                }
                else
                {
                    imageViewConseil.setImageResource(R.drawable.veste);
                    textToAdvice = "Il fait froid et un peu humide, je vous conseil de prendre une veste";
                }
                break;
            default:
                if(tempStatement)
                {
                    imageViewConseil.setImageResource(R.drawable.tshirt);
                    textToAdvice = "Il fait chaud et sec, je vous conseil des habits légers";
                }
                else
                {
                    imageViewConseil.setImageResource(R.drawable.doudoune);
                    textToAdvice = "Il fait froid, je vous conseille une doudoune";
                }
                break;
        }
        textViewConseil.setText(textToAdvice);

    }

    private void init() {
        buttonAskAgenda = findViewById(R.id.btAskAgenda);
        textViewConseil = findViewById(R.id.tvConseil);
        textViewHumidite = findViewById(R.id.tvHumidity);
        textViewTemperature = findViewById(R.id.tvTemp);
        imageViewConseil = findViewById(R.id.imageConseil);
    }
}