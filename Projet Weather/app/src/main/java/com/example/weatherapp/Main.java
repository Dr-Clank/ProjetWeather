package com.example.weatherapp;

import java.io.Serializable;

public class Main implements Serializable {

    private String temp;
    private String humidity;

    public String getTemp() {
        return temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public Main(String temp, String humidity, String temp_min, String temp_max) {
        this.temp = temp;
        this.humidity = humidity;
    }
}