package com.mycompany.uutislukija.service;

import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import com.mycompany.uutislukija.domain.Uutinen;
import com.mycompany.uutislukija.util.HackerNewsParser;
import org.springframework.stereotype.Component;

@Component
public class HackerNews implements Uutispalvelu {
    
    private HackerPaivanUutiset hakija;
    
    public HackerNews(HackerPaivanUutiset hakija) {
        this.hakija = hakija;
    }
    
    @Override
    public Uutinen haeViimeisin() {
        Uutinen suosituin = HackerNewsParser.parseUutinen(
            hakija.haeViimeisinUutinen()
        );
        return suosituin;
    }
    
    @Override
    public Uutinen haeSuosituin() {
        Uutinen suosituin = HackerNewsParser.parseUutinen(
            hakija.haeSuosituinUutinen()
        );
        return suosituin;
    }
    
}
