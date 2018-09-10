package no.hvl.dat152.oblig1.CustomTags;

import no.hvl.dat152.oblig1.model.DescriptionEAO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DescriptionTAG extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
        try {
            DescriptionEAO description = DescriptionEAO.getInstance();

            getJspContext().getOut().write(description.getDescription(key, langCode).getText());

        } catch (Exception e) {
            e.printStackTrace();
            // stop page from loading further by throwing SkipPageException
            throw new SkipPageException("Something failed??");
        }
    }

    int key;
    String langCode;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

}
