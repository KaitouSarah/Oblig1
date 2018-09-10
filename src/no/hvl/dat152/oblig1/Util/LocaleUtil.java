package no.hvl.dat152.oblig1.Util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

public class LocaleUtil {
	public static String getLanguage(HttpServletRequest req, String forceLang) {
		Enumeration<Locale> locales = req.getLocales();
		Dictionary dictionary = Dictionary.getInstance();
		List<Language> languages = dictionary.getLanguages();

		if (forceLang != null) {
			return forceLang;
		}

		Cookie[] reqCookies = req.getCookies();
		if (reqCookies != null) {
			for (Cookie cookie: reqCookies) {
				if (!cookie.getName().equals("langCode")) {
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

	public static void setLanguageCookie(HttpServletRequest req, HttpServletResponse res) {
		String langCode = req.getParameter("langCode");

		if (langCode == null) {
			return;
		}


		res.addCookie(new Cookie("langCode", langCode));
	}
}