package no.hvl.dat152.oblig1.Util;

import java.util.HashMap;

public class CurrencyExchanger {

    private static CurrencyExchanger INSTANCE;
    private double nok = 9.8;
    private double usd = 1.16;

    public static CurrencyExchanger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CurrencyExchanger();
        }
        return INSTANCE;
    }

    public String convert(double euro, String langCode) {
        double sum = 0;
        String currency = "";
        if (langCode.equals("es")) {
            sum = euro;
            currency = "€";
        } else if (langCode.equals("no")) {
            sum = ((Math.round(euro * nok) * 100)) / 100;
            currency = "kr";
        } else if (langCode.equals("en")) {
            sum = ((Math.round(euro * usd) * 100)) / 100;
            currency = "$";
        }

        return (sum + " " + currency);
    }

    public double convertTotal(double euro, String langCode) {
        double sum = 0;
        if (langCode.equals("es")) {
            sum = euro;
        } else if (langCode.equals("no")) {
            sum = ((Math.round(euro * nok) * 100)) / 100;
        } else if (langCode.equals("en")) {
            sum = ((Math.round(euro * usd) * 100)) / 100;
        }

        return sum;

    }
}

