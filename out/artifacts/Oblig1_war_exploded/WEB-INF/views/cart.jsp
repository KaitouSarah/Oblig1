<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://journaldev.com/jsp/tlds/mytags" prefix="mytags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Cart</title>
        <link rel="stylesheet" href="public/style.css">
    </head>
    <body>
        <header>
            <a href="#">Norsk</a>
            <a href="#">Engelsk</a>
            <a href="#">Espanjol</a>
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
                <c:forEach items="${cart}" var="cart">
                    <tr>
                        <td>White Coffee Mug (TM)</td>
                        <td>This is the ultimate...</td>
                        <td>10</td>
                        <td>2</td>
                        <td>20</td>
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
