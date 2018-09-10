<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://journaldev.com/jsp/tlds/mytags" prefix="mytags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Products</title>
        <link rel="stylesheet" href="public/style.css">
    </head>
    <body>
        <header>
            <a href="/products?langCode=no">Norsk</a>
            <a href="/products?langCode=en">Engelsk</a>
            <a href="/products?langCode=es">Espanjol</a>
        </header>
        <main>
            <section class="products">
                <c:forEach items="${products}" var="product">
                    <ul>
                        <li>
                            <div class="product">
                                <h2>${product.pName}</h2>
                                <div class="productContent">
                                    <img src="${product.imageFile}" alt="">
                                    <div class="productDetails">
                                        <dl>
                                            <dt><mytags:translation key="name" langCode="${langCode}">: </mytags:translation> </dt>
                                            <dd>${product.pName}</dd>
                                            <dt><mytags:translation key="price" langCode="${langCode}">: </mytags:translation></dt>
                                            <dd><mytags:exchange eur="${product.priceInEuro}" langCode="${langCode}"></mytags:exchange></dd>
                                            <dt><mytags:translation key="description" langCode="${langCode}"></mytags:translation></dt>
                                            <dd><mytags:description key="${product.pno}" langCode="${langCode}"></mytags:description></dd>
                                        </dl>
                                        <button onclick="window.location.href='/cart'"><mytags:translation key="addToCart" langCode="${langCode}"></mytags:translation></button>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </c:forEach>
                <p class="bottomlinks"><a href="/home"><mytags:translation key="home" langCode="${langCode}"></mytags:translation></a>
                    <a href="/cart"><mytags:translation key="cart" langCode="${langCode}"></mytags:translation></a>
                </p>
            </section>
        </main>
    </body>
    <footer>
        <mytags:Copyright since="2008">HVL</mytags:Copyright>
    </footer>
</html>
