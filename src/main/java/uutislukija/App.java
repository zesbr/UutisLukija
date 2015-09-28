package uutislukija;



import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import uutislukija.config.WebConfig;
import uutislukija.service.HackerNews;
import java.io.IOException;

public class App {
    public static void main(String[] args){
        try {
            new WebConfig(new HackerNews(new HackerPaivanUutiset()));
        } catch (IOException exception) {
            System.out.println("*ERROR*");
        }
    }
 
}
