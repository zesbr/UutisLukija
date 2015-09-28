package uutislukija;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spark.Spark;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;


public class AppTest extends FluentTest {
    
    public WebDriver webDriver = new HtmlUnitDriver();
    public WebDriver getDefaultDriver(){
        return webDriver;
    }
    
    @ClassRule
    public static ServerRule server = new ServerRule();
    
    @Test
    public void etusivuNayttaaOikeanSivuOtsikonJaOikeatLinkit(){
        goTo("http://localhost:4567/");
        assertTrue(pageSource().contains("Hackernews-Uutiset"));
        assertTrue(pageSource().contains("Viimeisin"));
        assertTrue(pageSource().contains("Suosituin"));
    }
    
    @Test
    public void suosituinNayttaaOikeanSivuOtsikonJaLinkinUutiseen(){
        goTo("http://localhost:4567/suosituin");
        assertTrue(pageSource().contains("Suosituin uutinen"));
        assertTrue(pageSource().contains("Lue uutinen täältä"));
        
    }
    
    @Test
    public void viimeisinNayttaaOikeanSivuOtsikonJaLinkinUutiseen(){
        goTo("http://localhost:4567/viimeisin");
        assertTrue(pageSource().contains("Viimeisin uutinen"));
        assertTrue(pageSource().contains("Lue uutinen täältä"));
    }
     
}
