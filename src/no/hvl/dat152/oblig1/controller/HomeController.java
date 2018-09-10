package no.hvl.dat152.oblig1.controller;

import no.hvl.dat152.oblig1.Util.LocaleUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocaleUtil.setLanguageCookie(req, resp);
        String langCode = LocaleUtil.getLanguage(req, req.getParameter("langCode"));
        req.setAttribute("langCode", langCode);
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
    }
}
