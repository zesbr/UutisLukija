package com.mycompany.uutislukija.service;

import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.uutislukija.domain.Uutinen;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HackerNewsTest {
    
    HackerPaivanUutiset hakija;
    
    @Before
    public void setUp() {
        hakija = mock(HackerPaivanUutiset.class);
        when(hakija.haeViimeisinUutinen()).thenReturn(
            "Where are the missing gravitational waves?, url: " +
            "https://theconversation.com/where-are-the-missing-gravitational-waves-47940"       
        );       
        when(hakija.haeSuosituinUutinen()).thenReturn(
            "Nix the Tricks: Math tricks defeat understanding, url: " +
            "http://www.nixthetricks.com/#hn-repost"
        );
    }
    
    @Test
    public void haeViimeisinPalauttaaViimeisimmanUutisen() {
        HackerNews hackerNews = new HackerNews(hakija);
        Uutinen viimeisin = hackerNews.haeViimeisin();
        assertEquals(
            "Where are the missing gravitational waves?", 
            viimeisin.getOtsikko()
        );
        assertEquals(
            "https://theconversation.com/where-are-the-missing-gravitational-waves-47940",
            viimeisin.getUrl()
        );
    }
    
    @Test
    public void haeSuosituinPalauttaaSuosituimmanUutisen() {
        HackerNews hackerNews = new HackerNews(hakija);
        Uutinen suosituin = hackerNews.haeSuosituin();
        assertEquals(
            "Nix the Tricks: Math tricks defeat understanding",
            suosituin.getOtsikko()
        );
        assertEquals(
            "http://www.nixthetricks.com/#hn-repost",
            suosituin.getUrl()
        );
    }
    
}
