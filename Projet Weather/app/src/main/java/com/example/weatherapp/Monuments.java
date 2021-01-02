package com.example.weatherapp;

public class Monuments {

    public Monuments(String nom, String latitude, String longitude) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNom() {
        return nom;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    private String nom;
    private String latitude;
    private String longitude;

}
