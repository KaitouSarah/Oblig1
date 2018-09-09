package no.hvl.dat152.oblig1;

import no.hvl.dat152.oblig1.model.Product;
import no.hvl.dat152.oblig1.model.ProductEAO;

public class Main {
	static void initializeDatabase() {
		ProductEAO productEAO = ProductEAO.getInstance();

		productEAO.createProduct(1, "White Coffee Mug (TM)", 10, "public/images/whitemug.png");
		productEAO.createProduct(2, "Black Coffee Mug (TM)", 11, "public/images/blackmug2.jpg");


	}
}
