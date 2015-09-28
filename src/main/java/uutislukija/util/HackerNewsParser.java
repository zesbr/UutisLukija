package uutislukija.util;

import uutislukija.domain.Uutinen;

public class HackerNewsParser {

    public static Uutinen parseUutinen(String str) {
        String[] attribs = str.split(", url: ");
        return new Uutinen(attribs[0], attribs[1]);
    }
    
}
