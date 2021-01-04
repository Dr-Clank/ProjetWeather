package com.example.weatherapp;

import java.io.Serializable;

public class Ville implements Serializable {
    private String _nom;

    public Ville(String _nom) {
        this._nom = _nom;
    }

    public String get_nom()
    {
        return _nom;
    }

    @Override
    public String toString()
    {
        return _nom;
    }
}
