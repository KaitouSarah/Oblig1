package no.hvl.dat152.oblig1.controller;

import no.hvl.dat152.oblig1.Util.LocaleUtil;
import no.hvl.dat152.oblig1.model.Product;
import no.hvl.dat152.oblig1.model.ProductEAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductEAO productEAO = ProductEAO.getInstance();

		List<Product> products = productEAO.getProducts();

		String langCode = LocaleUtil.getLanguage(req);

		req.setAttribute("langCode", langCode);
		req.setAttribute("products", products);
        req.getRequestDispatcher("WEB-INF/views/test.jsp").forward(req, resp);
    }
}
