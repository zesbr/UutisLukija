package com.mycompany.uutislukija.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UutinenTest {
    
   Uutinen uutinen;
    
    @Before
    public void setUp() {
        uutinen = new Uutinen(
            "Nix the Tricks: Math tricks defeat understanding", 
            "http://www.nixthetricks.com/#hn-repost"
        );
    }
    
    @Test
    public void getOtsikkoReturnsCorrectTitle() {
        assertEquals(
            "Nix the Tricks: Math tricks defeat understanding", 
             uutinen.getOtsikko()
        );
    }
    
    @Test
    public void getUrlReturnsCorrectUrl() {
        assertEquals(
            "http://www.nixthetricks.com/#hn-repost", 
             uutinen.getUrl()
        );
    }

}
