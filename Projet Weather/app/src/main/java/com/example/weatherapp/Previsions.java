package com.example.weatherapp;

import java.io.Serializable;
import java.util.List;

public class Previsions implements Serializable {
    private List<Prevision> list;

    public City getCity() {
        return city;
    }

    private City city;

    public Previsions(List<Prevision> list, City city)
    {
        this.list = list;
        this.city = city;
    }

    public List<Prevision> getPrevisions() {
        return list;
    }
}