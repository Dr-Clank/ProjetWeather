package com.example.weatherapp;

public class Ville {
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
