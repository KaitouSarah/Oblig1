package no.hvl.dat152.oblig1.Util;

import java.util.ArrayList;
import java.util.List;

class Language {
	private final String langCode;
	private final String name;

	public Language(String langCode, String name) {
		this.langCode = langCode;
		this.name = name;
	}

	public String getLangCode() {
		return langCode;
	}

	public String getName() {
		return name;
	}
}

class Translation {
	private String key;
	private String langCode;
	private String text;

	public Translation(String key, String langCode, String text) {
		this.key = key;
		this.langCode = langCode;
		this.text = text;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

public class Dictionary {
	private List<Language> languages = new ArrayList<>();
	private Language defaultLangauge;

	private List<Translation> translations = new ArrayList<>();

	private static Dictionary INSTANCE;

	public static Dictionary getInsstance() {
		if (INSTANCE == null) {
			INSTANCE = new Dictionary();
		}
		return INSTANCE;
	}

	public void addLanguage(String langCode, String name) {
		Language language = new Language(langCode, name);

		if (defaultLangauge == null) {
			defaultLangauge = language;
		}

		languages.add(language);
	}

	public void addTranslation(String key, String langCode, String text) throws Exception {
		if (getLanguage(langCode) == null) {
			throw new Exception("Invalid langCode");
		}
		translations.add(new Translation(key, langCode, text));
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public Language getLanguage(String langCode) {
		for (Language langauge: languages) {
			if (langauge.getLangCode().equals(langCode)) {
				return langauge;
			}
		}

		return null;
	}

	public String translate(String key, String langCode) {
		for (Translation translation: translations) {
			if (translation.getKey().equals(key) && translation.getLangCode().equals(langCode)) {
				return translation.getText();
			}
		}

		return null;
	}

	public Language getDefaultLangauge() {
		return defaultLangauge;
	}

	public void setDefaultLangauge(Language defaultLangauge) {
		this.defaultLangauge = defaultLangauge;
	}
}
