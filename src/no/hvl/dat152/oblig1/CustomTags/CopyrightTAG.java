package no.hvl.dat152.oblig1.CustomTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CopyrightTAG extends SimpleTagSupport{

    private int since;

    @Override
    public void doTag() throws JspException {
        String romanNumeralsSince = IntegerToRomanNumeral(since);
        try {
            getJspContext().getOut().write("&copy; " + romanNumeralsSince + " Javascripters");
            getJspBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipPageException("Feil");
        }
    }

    public static String IntegerToRomanNumeral(int input) {
        if (input < 1 || input > 3999)
            return "Invalid Roman Number Value";
        String s = "";
        while (input >= 1000) {
            s += "M";
            input -= 1000;        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }
    public int getSince() {
        return since;
    }

    public void setSince(int since) {
        this.since = since;
    }
}
