package uutislukija;

import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import uutislukija.service.HackerNews;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.get;
import static spark.SparkBase.port;
import spark.template.freemarker.FreeMarkerEngine;
import uutislukija.service.Uutispalvelu;

public class App {
    public static void main(String[] args){
        Uutispalvelu uutispalvelu = new HackerNews(new HackerPaivanUutiset());
        Configuration config = new Configuration(Configuration.VERSION_2_3_23);
        config.setTemplateLoader(new ClassTemplateLoader(App.class, "/templates"));
        
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
