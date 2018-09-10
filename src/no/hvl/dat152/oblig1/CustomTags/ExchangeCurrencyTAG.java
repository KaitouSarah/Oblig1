package no.hvl.dat152.oblig1.CustomTags;

import no.hvl.dat152.oblig1.Util.CurrencyExchanger;
import no.hvl.dat152.oblig1.model.Product;
import no.hvl.dat152.oblig1.model.ProductEAO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ExchangeCurrencyTAG extends SimpleTagSupport{

    double eur;
    String langCode;

    CurrencyExchanger ce = CurrencyExchanger.getInstance();

    @Override
    public void doTag() throws JspException {
        try {
            getJspContext().getOut().write(ce.convert(eur, langCode));
            getJspBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipPageException("Feil");
        }
    }

    public double getEur() {
        return eur;
    }

    public void setEur(double eur) {
        this.eur = eur;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
}
