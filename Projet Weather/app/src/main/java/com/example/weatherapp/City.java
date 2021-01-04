package com.example.weatherapp;
import java.io.Serializable;

public class City implements Serializable {

    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    private String country;

    public City(int id, String name, String country)
    {
        this.id = id;
        this.name=name;
        this.country = country;
    }
}

