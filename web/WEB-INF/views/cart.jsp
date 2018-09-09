<%@ taglib uri="no.hvl.dat152.oblig1.CustomTags.CopyrightTAG" prefix="c"%>
<%@ taglib uri="no.hvl.dat152.oblig1.CustomTags.CopyrightTAG" prefix="mytags"%>
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
                    <th>Name</th>
                    <th>Short description</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                </tr>
                <c:forEach items="${products}" var="carr">
                    <tr>
                        <td>White Coffee Mug (TM)</td>
                        <td>This is the ultimate...</td>
                        <td>10</td>
                        <td>2</td>
                        <td>20</td>
                    </tr>
                </c:forEach>
            </table>
            <p class="bottomlinks"><a href="/home">Home</a> <a href="/products">Products</a></p>
        </main>
    </body>
    <footer>
        <mytags:Copyright since="2008">HVL</mytags:Copyright>
    </footer>
</html>
