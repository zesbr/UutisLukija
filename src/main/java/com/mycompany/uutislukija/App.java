package com.mycompany.uutislukija;

import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import com.mycompany.uutislukija.config.WebConfig;
import com.mycompany.uutislukija.service.HackerNews;
import java.io.IOException;

public class App {
    public static void main(String[] args){
        try {
            new WebConfig(new HackerNews(new HackerPaivanUutiset()));
        } catch (IOException exception) {
            System.out.println("*ERROR*");
        }
    }
    
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
