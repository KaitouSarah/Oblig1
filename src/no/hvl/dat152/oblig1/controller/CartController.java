package no.hvl.dat152.oblig1.controller;


import no.hvl.dat152.oblig1.Util.LocaleUtil;
import no.hvl.dat152.oblig1.model.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class CartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = new Cart();
        List<Integer> cartProducts = cart.getCart();

        String langCode = LocaleUtil.getLanguage(req);
        req.setAttribute("langCode", langCode);
        req.setAttribute("cart", cartProducts);
        req.getRequestDispatcher("WEB-INF/views/cart.jsp").forward(req, resp);
    }
}
