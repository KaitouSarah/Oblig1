package no.hvl.dat152.oblig1.model;

public class CartItem {
	private int pno;
	private int quantity;

	public int getPno() {
		return pno;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotal() {
		Product product = ProductEAO.getInstance().getProduct(pno);

		return product.getPriceInEuro() * quantity;
	}

	public CartItem (int pno, int quantity) {
		this.pno = pno;
		this.quantity = quantity;
	}
}
