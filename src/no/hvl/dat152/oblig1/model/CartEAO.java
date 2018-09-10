package no.hvl.dat152.oblig1.model;

import no.hvl.dat152.oblig1.Database.DatabaseEAOModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartEAO extends DatabaseEAOModel {

    public CartEAO() {
        super("cart");
    }

    private static CartEAO INSTANCE;

    public static CartEAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CartEAO();
        }
        return INSTANCE;
    }

    public int addToCart(int pno) {
        return 0;
    }

}
