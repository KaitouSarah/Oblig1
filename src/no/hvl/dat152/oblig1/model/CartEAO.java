package no.hvl.dat152.oblig1.model;

import no.hvl.dat152.oblig1.Database.DatabaseEAOModel;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

	private Cart mapObjectToCart(HashMap<String, Object> object) {
		List<HashMap<String, Object>> itemObjects = (List<HashMap<String, Object>>) object.get("items");

		List<CartItem> items = itemObjects
			.stream()
			.map(itemObject -> {
				int pno = (int) itemObject.get("pno");
				int quantity = (int) itemObject.get("quantity");

				return new CartItem(pno, quantity);
			})
			.collect(Collectors.toList());

		int cartId = (int)object.get("cartId");

		return new Cart(cartId, items);
	}

	private HashMap<String, Object> mapCartToObject(Cart cart) {
		List<CartItem> items = cart.getItems();

		List<HashMap<String, Object>> itemObjects = items
			.stream()
			.map(item -> {
				HashMap<String, Object> itemObject = new HashMap<>();

				itemObject.put("pno", item.getPno());
				itemObject.put("quantity", item.getQuantity());

				return itemObject;
			})
			.collect(Collectors.toList());


		HashMap<String, Object> cartObject = new HashMap<>();
		cartObject.put("items", itemObjects);
		cartObject.put("cartId", cart.getCartId());

		return cartObject;
	}

	public Cart getCart(int cartId) {
		HashMap<String, Object> cartObject = getObject("cartId", cartId);

		return mapObjectToCart(cartObject);
	}

	public Cart createCart(int cartId) {
		Cart cart = new Cart(cartId);

		HashMap<String, Object> object = mapCartToObject(cart);

		createObject(object);

		return cart;
	}

	public void addCartItemToCart(int cartId, int pno, int quantity) {
		CartItem cartItem = new CartItem(pno, quantity);

		HashMap<String, Object> cartObject = getObject("cartId", cartId);
		Cart cart = mapObjectToCart(cartObject);

		cart.addItem(cartItem);

		cartObject = mapCartToObject(cart);

		replaceObject(cartObject, _cartObject -> (int) _cartObject.get("cartId") == cart.getCartId());
	}
}
