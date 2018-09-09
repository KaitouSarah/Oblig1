package no.hvl.dat152.oblig1;

import no.hvl.dat152.oblig1.Util.Dictionary;
import no.hvl.dat152.oblig1.model.DescriptionEAO;
import no.hvl.dat152.oblig1.model.ProductEAO;

public class Main {
	static void initializeDatabase() throws Exception {
		ProductEAO productEAO = ProductEAO.getInstance();
		DescriptionEAO descriptionEAO = DescriptionEAO.getInstance();

		productEAO.createProduct(1, "White Coffee Mug (TM)", 10, "public/images/whitemug.png");
		descriptionEAO.createDescription(1, "en", "This is the ultimate cup for programmers who sit late evenings and need a little wake up.");
		descriptionEAO.createDescription(1, "no", "Dette er den ultimate koppen for programutviklere som sitter sene kvelder og trenger litt å holde seg våken på.");
		descriptionEAO.createDescription(1, "es", "Este es el ultimato taza para software developers que trabajan en las noches y nessecitan algo para no dormir.");

		productEAO.createProduct(2, "Black Coffee Mug (TM)", 11, "public/images/blackmug2.jpg");
		descriptionEAO.createDescription(2, "en", "This is the ultimate cup for programmers who sit late evenings and need a little wake up.");
		descriptionEAO.createDescription(2, "no", "Dette er den ultimate koppen for programutviklere som sitter sene kvelder og trenger litt å holde seg våken på.");
		descriptionEAO.createDescription(2, "es", "Este es una taza para ellos que gusta el colore negra. La taza es muy bueno para café, té y leche, pero es tambien posible usarla con otro bebidas");

		Dictionary dictionary = Dictionary.getInsstance();

		dictionary.addLanguage("en", "English (US)");
		dictionary.addLanguage("no", "Norsk");
		dictionary.addLanguage("es", "Espanjol");

		dictionary.addTranslation("home", "en", "Home");
		dictionary.addTranslation("home", "no", "Hjem");
		dictionary.addTranslation("home", "es", "Hjemos");

		dictionary.addTranslation("products", "en", "Products");
		dictionary.addTranslation("products", "no", "Produkter");
		dictionary.addTranslation("products", "es", "Produktos");

		dictionary.addTranslation("cart", "en", "Cart");
		dictionary.addTranslation("cart", "no", "Handlekurv");
		dictionary.addTranslation("cart", "es", "Handloskurvos");

		dictionary.addTranslation("haveALookAtOurWonderful", "en", "Have a look at our wonderful");
		dictionary.addTranslation("haveALookAtOurWonderful", "no", "Ta en titt på våre fantastiske");
		dictionary.addTranslation("haveALookAtOurWonderful", "es", "Taos en tittos aki oura el fantastico");

		dictionary.addTranslation("name", "en", "Name");
		dictionary.addTranslation("name", "no", "Navn");
		dictionary.addTranslation("name", "es", "Navnos");

		dictionary.addTranslation("price", "en", "Price");
		dictionary.addTranslation("price", "no", "Pris");
		dictionary.addTranslation("price", "es", "Prisos");

		dictionary.addTranslation("description", "en", "Description");
		dictionary.addTranslation("description", "no", "Beskrivelse");
		dictionary.addTranslation("description", "es", "Beskrivelsos");

		dictionary.addTranslation("addToCart", "en", "Add to cart");
		dictionary.addTranslation("addToCart", "no", "Legg i handlekurv");
		dictionary.addTranslation("addToCart", "es", "Leggos i handloskurvos");

		dictionary.addTranslation("shortDescription", "en", "Short description");
		dictionary.addTranslation("shortDescription", "no", "Kort beskrivelse");
		dictionary.addTranslation("shortDescription", "es", "Kortos beskrivelsos");

		dictionary.addTranslation("total", "en", "Total");
		dictionary.addTranslation("total", "no", "Total");
		dictionary.addTranslation("total", "es", "Totalos");

		dictionary.addTranslation("totalAmount", "en", "Total amount");
		dictionary.addTranslation("totalAmount", "no", "Total mengde");
		dictionary.addTranslation("totalAmount", "es", "Totalos los mengdos");
	}
}
