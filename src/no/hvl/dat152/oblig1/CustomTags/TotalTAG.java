package no.hvl.dat152.oblig1.CustomTags;

import no.hvl.dat152.oblig1.Util.CurrencyExchanger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TotalTAG extends SimpleTagSupport {

    private int quantity;
    private double price;
    private String langCode;

    @Override
    public void doTag() throws JspException {
        try {
            getJspContext().getOut().write(total(quantity, price, langCode));
            getJspBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipPageException("Feil");
        }
    }

    public String total(int quantity, double price, String langCode) {
        CurrencyExchanger ce = new CurrencyExchanger();
        double sum;
        String currency;
        if (langCode.equals("es")) {
            sum = price * quantity;
            currency = "€";
        } else if (langCode.equals("no")) {
            sum = ce.convertTotal(price, langCode) * quantity;
            currency = "kr";
        } else {
            sum = ce.convertTotal(price, langCode);
            currency = "$";
        }
        return (sum + " " + currency);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
}
