package com.example.weatherapp;

import java.io.Serializable;

public class Prevision implements Serializable {
    public Main getMain() {
        return main;
    }

    private Main main;

    public Prevision(Main main)
    {
        this.main = main;
    }

    @Override
    public String toString()
    {
        return "La température est actuellement de  " + main.getTemp() + ". L'humidité est de " + main.getHumidity()+ ".";
    }
}
