package no.hvl.dat152.oblig1.Util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

public class LocaleUtil {
	public static String getLanguage(HttpServletRequest req) {
		Enumeration<Locale> locales = req.getLocales();
		Dictionary dictionary = Dictionary.getInstance();
		List<Language> languages = dictionary.getLanguages();

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie: cookies) {
				if (!cookie.getName().equals("language")) {
					continue;
				}
				String langCode = cookie.getValue();

				for (Language language: languages) {
					if (language.getLangCode().equals(langCode)) {
						return langCode;
					}
				}
			}
		}

		for (Locale locale: Collections.list(locales)) {
			for (Language language: languages) {
				if (locale.getLanguage().equals(language.getLangCode())) {
					return language.getLangCode();
				}
			}
		}

		return dictionary.getDefaultLangauge().getLangCode();
	}
}
