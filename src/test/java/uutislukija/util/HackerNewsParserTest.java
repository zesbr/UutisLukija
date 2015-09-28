package uutislukija.util;

import uutislukija.util.HackerNewsParser;
import uutislukija.domain.Uutinen;
import org.junit.Test;
import static org.junit.Assert.*;

public class HackerNewsParserTest {

    @Test
    public void parseUutinenReturnNewUutinenWithCorrectPropertyValues() {
        Uutinen uutinen = HackerNewsParser.parseUutinen(
            "Nix the Tricks: Math tricks defeat understanding, url: " +
            "http://www.nixthetricks.com/#hn-repost"
        );
        assertEquals(
            "Nix the Tricks: Math tricks defeat understanding", 
             uutinen.getOtsikko()
        );
        assertEquals(
            "http://www.nixthetricks.com/#hn-repost", 
             uutinen.getUrl()
        );
    }
}
