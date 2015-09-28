package com.mycompany.uutislukija.domain;

public class Uutinen {

    private String otsikko;
    private String url;
    
    public Uutinen(String otsikko, String url) {
        this.otsikko = otsikko;
        this.url = url;
    }
    
    public String getOtsikko() {
        return this.otsikko;
    }
    
    public String getUrl() {
        return this.url;
    }
    
}
