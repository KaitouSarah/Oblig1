package no.hvl.dat152.oblig1.controller;


import no.hvl.dat152.oblig1.Util.LocaleUtil;
import no.hvl.dat152.oblig1.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class CartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartEAO cartEAO = CartEAO.getInstance();
        Cart cart = cartEAO.getCart(1);
        ProductEAO productEAO = ProductEAO.getInstance();
        DescriptionEAO descriptionEAO = DescriptionEAO.getInstance();

        LocaleUtil.setLanguageCookie(req, resp);
        String langCode = LocaleUtil.getLanguage(req, req.getParameter("langCode"));
        req.setAttribute("descriptionEAO", descriptionEAO);
        req.setAttribute("productEAO", productEAO);
        req.setAttribute("cart", cart);
        req.setAttribute("langCode", langCode);
        req.getRequestDispatcher("WEB-INF/views/cart.jsp").forward(req, resp);
    }
}
