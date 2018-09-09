package no.hvl.dat152.oblig1.model;

import no.hvl.dat152.oblig1.Database.DatabaseEAOModel;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ProductEAO extends DatabaseEAOModel {
	public ProductEAO() {
		super("product");
	}

	private static ProductEAO INSTANCE;

	public static ProductEAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ProductEAO();
		}
		return INSTANCE;
	}

	private Product mapObjectToProduct(HashMap<String, Object> object) {
		int pno = (int) object.get("pno");
		String pName = (String) object.get("pName");
		double priceInEuro = (double) object.get("priceInEuro");
		String imageFile = (String) object.get("imageFile");

		return new Product(pno, pName, priceInEuro, imageFile);
	}

	private HashMap<String, Object> mapProductToObject(Product product) {
		HashMap<String, Object> object = new HashMap<>();

		object.put("pno", product.getPno());
		object.put("pName", product.getpName());
		object.put("priceInEuro", product.getPriceInEuro());
		object.put("imageFile", product.getImageFile());

		return object;
	}

	public Product getProduct(int pno) {
		HashMap<String, Object> productObject = getObject("pno", pno);

		return mapObjectToProduct(productObject);
	}

	public List<Product> getProducts() {
		List<HashMap<String, Object>> productObjects = getObjects();

		return productObjects
			.stream()
			.map(this::mapObjectToProduct)
			.collect(Collectors.toList());
	}

	public Product createProduct(int pno, String pName, double priceInEuro, String imageFile) {
		Product product = new Product(pno, pName, priceInEuro, imageFile);

		HashMap<String, Object> object = mapProductToObject(product);

		createObject(object);

		return product;
	}
}
