package uutislukija.service;

import uutislukija.domain.Uutinen;

public interface Uutispalvelu {   
    
    public Uutinen haeSuosituin();
    public Uutinen haeViimeisin();   

}