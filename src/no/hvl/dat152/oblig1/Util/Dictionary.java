package no.hvl.dat152.oblig1.Util;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private static Dictionary INSTANCE;
    private List<Translation> translations = new ArrayList<>();

    public static Dictionary getInsstance() {
        if (INSTANCE == null) {
            INSTANCE = new Dictionary();
        }
        return INSTANCE;
    }

    public Translation findTranslation (String langCode, String key) {
        for (int i = 0; i < translations.size(); i++) {
            Translation t = translations.get(i);
            if (t.getKey() == key && t.getLangCode() == langCode) {
               return t;
            }
        }
        return null;
    }

    public void addTranslation(Translation trans) {
        translations.add(trans);
    }

    public List<Translation> getTranslations() {
        return translations;
    }
}
