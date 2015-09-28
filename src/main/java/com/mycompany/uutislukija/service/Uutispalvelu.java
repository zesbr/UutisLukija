package com.mycompany.uutislukija.service;

import com.mycompany.uutislukija.domain.Uutinen;

public interface Uutispalvelu {   
    
    public Uutinen haeSuosituin();
    public Uutinen haeViimeisin();   

}