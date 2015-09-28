package uutislukija.config;

import uutislukija.config.WebConfig;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import uutislukija.domain.Uutinen;
import uutislukija.service.HackerNews;
import uutislukija.service.Uutispalvelu;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
        
public class WebConfigTest {
    
    Uutispalvelu uutispalvelu;
    WebConfig config;
    
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);
    
    @Before
    public void setUp() throws IOException {
        uutispalvelu = mock(HackerNews.class); 
        when(uutispalvelu.haeViimeisin()).thenReturn(
            new Uutinen(
                "Where are the missing gravitational waves?",
                "https://theconversation.com/where-are-the-missing-gravitational-waves-47940"
            )
        );  
        when(uutispalvelu.haeSuosituin()).thenReturn(
            new Uutinen(
                "Nix the Tricks: Math tricks defeat understanding",
                "http://www.nixthetricks.com/#hn-repost"
            )
        );
        this.config = new WebConfig(uutispalvelu);
        stubFor(get(urlEqualTo("/some/thing"))
            .willReturn(aResponse()
                .withHeader("Content-Type", "text/plain")
                .withBody("Hello world!")));

        
    }
    
}
