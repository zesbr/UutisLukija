package com.mycompany.uutislukija.config;

import com.mycompany.uutislukija.App;
import com.mycompany.uutislukija.service.Uutispalvelu;
import freemarker.cache.ClassTemplateLoader;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.get;
import spark.template.freemarker.FreeMarkerEngine;
import freemarker.template.Configuration;
import java.io.IOException;
import static spark.SparkBase.port;

public class WebConfig {
    
    Configuration config;
    Uutispalvelu uutispalvelu;
      
    public WebConfig(Uutispalvelu uutispalvelu) throws IOException {
        this.uutispalvelu = uutispalvelu;
        this.config = new Configuration(Configuration.VERSION_2_3_23);
        this.config.setTemplateLoader(new ClassTemplateLoader(App.class, "/templates"));
        setupRoutes();
    }
    
    public void setupRoutes() {
        port(getHerokuAssignedPort());
        
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.ftl");
        },new FreeMarkerEngine(config));
        
        get("/viimeisin", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("title", "Viimeisin uutinen");
            model.put("uutinen", uutispalvelu.haeViimeisin());
            return new ModelAndView(model, "show.ftl");
        }, new FreeMarkerEngine(config));
        
        get("/suosituin", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("title", "Suosituin uutinen");
            model.put("uutinen", uutispalvelu.haeSuosituin());
            return new ModelAndView(model, "show.ftl");
        }, new FreeMarkerEngine(config));
        
    }
    
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    
}
