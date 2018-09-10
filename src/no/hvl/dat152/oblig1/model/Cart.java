package no.hvl.dat152.oblig1.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //Liste med produktnummer til produkter i handlevogn
    List<Integer> cart = new ArrayList<>();

    public List<Integer> getCart() {
        return cart;
    }

    public void setCart(List<Integer> cart) {
        this.cart = cart;
    }
}
