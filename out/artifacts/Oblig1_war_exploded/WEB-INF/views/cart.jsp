<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://journaldev.com/jsp/tlds/mytags" prefix="mytags"%>
<%@ taglib prefix="mytag" uri="https://journaldev.com/jsp/tlds/mytags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Cart</title>
        <link rel="stylesheet" href="public/style.css">
    </head>
    <body>
        <header>
            <a href="/cart?langCode=no">Norsk</a>
            <a href="/cart?langCode=en">Engelsk</a>
            <a href="/cart?langCode=es">Espanjol</a>
        </header>
        <main>
            <h1>Cart</h1>
            <table class="cartTable">
                <tr>
                    <th><mytags:translation key="name" langCode="${langCode}"></mytags:translation></th>
                    <th><mytags:translation key="shortDescription" langCode="${langCode}"></mytags:translation></th>
                    <th><mytags:translation key="price" langCode="${langCode}"></mytags:translation></th>
                    <th><mytags:translation key="quantity" langCode="${langCode}"></mytags:translation></th>
                    <th><mytags:translation key="total" langCode="${langCode}"></mytags:translation></th>
                </tr>
                <c:forEach items="${cart.getItems()}" var="cartItem">
                    <tr>
                        <td>${productEAO.getProduct(cartItem.getPno()).getpName()}</td>
                        <td><mytags:truncate shortDescription="${descriptionEAO.getDescription(productEAO.getProduct(cartItem.getPno()).getPno(), langCode).getText()}"></mytags:truncate></td>
                        <td><mytag:exchange eur="${productEAO.getProduct(cartItem.getPno()).getPriceInEuro()}" langCode="${langCode}"></mytag:exchange></td>
                        <td>${cartItem.getQuantity()}</td>
                        <td><mytags:total price="${productEAO.getProduct(cartItem.getPno()).getPriceInEuro()}"
                                          langCode="${langCode}" quantity="${cartItem.getQuantity()}"></mytags:total></td>
                    </tr>
                </c:forEach>
            </table>
            <p class="bottomlinks"><a href="/home"><mytags:translation key="home" langCode="${langCode}"></mytags:translation></a>
                <a href="/cart"><mytags:translation key="cart" langCode="${langCode}"></mytags:translation></a>
            </p>
        </main>
    </body>
    <footer>
        <mytags:Copyright since="2008">HVL</mytags:Copyright>
    </footer>
</html>
