package no.hvl.dat152.oblig1.CustomTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TruncateTAG extends SimpleTagSupport {

    String shortDescription;
    @Override
    public void doTag() throws JspException {
        try {
            getJspContext().getOut().write(truncate(shortDescription));
            getJspBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipPageException("Feil");
        }
    }

    public String truncate(String shortDescription) {
        if (shortDescription.length() > 30) {
            return (shortDescription.substring(0, Math.min(shortDescription.length(), 30)) + "...");
        } else {
            return shortDescription;
        }
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
