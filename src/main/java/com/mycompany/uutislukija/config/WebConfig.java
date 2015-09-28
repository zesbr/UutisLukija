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
import org.springframework.stereotype.Component;

@Component
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

        get("/", (request, response) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "index.ftl");
        },new FreeMarkerEngine(config));
        
        get("/viimeisin", (request, response) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("title", "Viimeisin uutinen");
            map.put("uutinen", uutispalvelu.haeViimeisin());
            return new ModelAndView(map, "show.ftl");
        }, new FreeMarkerEngine(config));
        
        get("/suosituin", (request, response) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("title", "Suosituin uutinen");
            map.put("uutinen", uutispalvelu.haeSuosituin());
            return new ModelAndView(map, "show.ftl");
        }, new FreeMarkerEngine(config));
        
    }
    
}
