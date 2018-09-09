<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="no.hvl.dat152.oblig1.CustomTags.CopyrightTAG" prefix="mytags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Products</title>
        <link rel="stylesheet" href="public/style.css">
    </head>
    <body>
        <header>
            <a href="#">Norsk</a>
            <a href="#">Engelsk</a>
            <a href="#">Espanjol</a>
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
                                            <dt>Navn: </dt>
                                            <dd>${product.pName}</dd>
                                            <dt>Pris: </dt>
                                            <dd>${product.priceInEuro}</dd>
                                            <dt>Beskrivelse</dt>
                                            <dd>Dette er den ultimate kopp for programvareutviklere som sitter sene kvelder og trenger noe for å ikke sovne</dd>
                                        </dl>
                                        <button onclick="window.location.href='/cart'">Legg i handlekurv</button>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </c:forEach>
                <p class="bottomlinks"><a href="/home">Home</a> <a href="/cart">Cart</a></p>
            </section>
        </main>
    </body>
    <footer>
        <mytags:Copyright since="2008">HVL</mytags:Copyright>
    </footer>
</html>
