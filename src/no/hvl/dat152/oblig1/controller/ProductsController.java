package no.hvl.dat152.oblig1.controller;


import no.hvl.dat152.oblig1.Util.LocaleUtil;
import no.hvl.dat152.oblig1.model.Description;
import no.hvl.dat152.oblig1.model.Product;
import no.hvl.dat152.oblig1.model.ProductEAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductEAO productEAO = ProductEAO.getInstance();
        LocaleUtil.setLanguageCookie(req, resp);
        String langCode = LocaleUtil.getLanguage(req, req.getParameter("langCode"));
        List<Product> products = productEAO.getProducts();

        req.setAttribute("products", products);
        req.setAttribute("langCode", langCode);
        req.getRequestDispatcher("WEB-INF/views/products.jsp").forward(req, resp);
    }
}

