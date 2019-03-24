package beerAdvisor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BeerMap {
    private final static Map<BeerColor, String> beers;

    static {
        HashMap<BeerColor, String> _beers = new HashMap<>();
        _beers.put(BeerColor.STRAW, "Flensburger Gold");
        _beers.put(BeerColor.GOLD, "Slavutich");
        _beers.put(BeerColor.BLACK, "Komes Porter");

        beers = Collections.unmodifiableMap(_beers);
    }

    public String getBeerByColor(BeerColor color) {
        return beers.get(color);
    }
}