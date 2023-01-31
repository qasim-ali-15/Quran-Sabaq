package com.example.myapplication.model;

public class QuranTable {
    private int id;
    private String name;
    private String sabaq;
    private String sabaqi;
    private String manzil;

    //constructors


    public QuranTable(Integer id, String name, String sabaq, String sabaqi, String manzil) {
        this.id = id;
        this.name = name;
        this.sabaq = sabaq;
        this.sabaqi = sabaqi;
        this.manzil = manzil;
    }

    public QuranTable(String name, String sabaq, String sabaqi, String manzil) {
        this.name = name;
        this.sabaq = sabaq;
        this.sabaqi = sabaqi;
        this.manzil = manzil;
    }

    public QuranTable(String name) {
        this.name = name;
    }

    public QuranTable() {
    }

    //getter and setter


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSabaq() {
        return sabaq;
    }

    public void setSabaq(String sabaq) {
        this.sabaq = sabaq;
    }

    public String getSabaqi() {
        return sabaqi;
    }

    public void setSabaqi(String sabaqi) {
        this.sabaqi = sabaqi;
    }

    public String getManzil() {
        return manzil;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }
}
