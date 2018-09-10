package no.hvl.dat152.oblig1.controller;

import no.hvl.dat152.oblig1.Util.LocaleUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/home");
        LocaleUtil.setLanguageCookie(req, resp);
    }
}
