package no.hvl.dat152.oblig1.Util;

import no.hvl.dat152.oblig1.Database.Database;

import java.util.HashMap;
import java.util.List;

public class CurrencyExchanger {

    private static CurrencyExchanger INSTANCE;

    public static CurrencyExchanger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CurrencyExchanger();
        }
        return INSTANCE;
    }
    //String langCode og double kurs fra euro
    private HashMap<String, Double> rates = new HashMap<>();


}
