package com.example.android.audiobookapp;

/**
 * Created by Samsung on 2018-03-22.
 */

public class Utwory {

    private String Rozdzial;
    private String Czas;

    public Utwory(String rozdzial, String czas){
        Rozdzial = rozdzial;
        Czas = czas;
    }

    public String getRozdzial(){
        return Rozdzial;
    }

    public String getCzas(){
        return Czas;
    }




}
