package uutislukija.service;

import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import uutislukija.domain.Uutinen;
import uutislukija.util.HackerNewsParser;

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
