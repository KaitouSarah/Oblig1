package no.hvl.dat152.oblig1.model;

import no.hvl.dat152.oblig1.Database.DatabaseEAOModel;

import java.util.HashMap;

public class DescriptionEAO extends DatabaseEAOModel {
	public DescriptionEAO() {
		super("description");
	}

	private static DescriptionEAO INSTANCE;

	public static DescriptionEAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DescriptionEAO();
		}
		return INSTANCE;
	}

	private Description mapObjectToDescription(HashMap<String, Object> object) {
		int pno = (int) object.get("pno");
		String langCode = (String) object.get("langCode");
		String text = (String) object.get("text");

		return new Description(pno, langCode, text);
	}

	private HashMap<String, Object> mapDescriptionToObject(Description description) {
		HashMap<String, Object> object = new HashMap<>();

		object.put("pno", description.getPno());
		object.put("langCode", description.getLangCode());
		object.put("text", description.getText());

		return object;
	}

	public Description getDescription(int pno, String langCode) {
		HashMap<String, Object> descriptionObject = getObject(object ->
			(int) object.get("pno") == pno && object.get("langCode").equals(langCode)
		);

		return mapObjectToDescription(descriptionObject);
	}

	public Description createDescription(int pno, String langCode, String text) {
		Description description = new Description(pno, langCode, text);

		HashMap<String, Object> object = mapDescriptionToObject(description);

		createObject(object);

		return description;
	}


}
