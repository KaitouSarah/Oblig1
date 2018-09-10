package no.hvl.dat152.oblig1.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> items;
	private int cartId;

	public List<CartItem> getItems() {
		return items;
	}

	public Cart (int cartId) {
		this.cartId = cartId;
		this.items = new ArrayList<>();
	}

	public Cart (int cartId, List<CartItem> items) {
		this.cartId = cartId;
		this.items = items;
	}

	public double getTotalAmount () {
		double totalAmount = items
			.stream()
			.mapToDouble(CartItem::getTotal)
			.sum();

		return totalAmount;
	}

	public int getCartId() {
		return cartId;
	}

	public void addItem(CartItem cartItem) {
		items.add(cartItem);
	}
}
