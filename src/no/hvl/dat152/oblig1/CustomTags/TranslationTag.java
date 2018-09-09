package no.hvl.dat152.oblig1.CustomTags;

import no.hvl.dat152.oblig1.Util.Dictionary;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.DecimalFormat;

public class TranslationTag extends SimpleTagSupport {
	private String key;
	private String langCode;

	@Override
	public void doTag() throws JspException {
		try {
			Dictionary dictionary = Dictionary.getInsstance();

			getJspContext().getOut().write(dictionary.translate(key, langCode));
		} catch (Exception e) {
			e.printStackTrace();
			// stop page from loading further by throwing SkipPageException
			throw new SkipPageException("Something failed??");
		}
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
}
