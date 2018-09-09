<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="no.hvl.dat152.oblig1.CustomTags.CopyrightTAG" prefix="mytags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Home</title>
        <link rel="stylesheet" href="public/style.css">
    </head>
    <body>
        <header>
            <a href="#">Norsk</a>
            <a href="#">Engelsk</a>
            <a href="#">Espanjol</a>
        </header>
        <main>
            <h1>Javascripters AS</h1>
            <img class="logo" src="public/images/logo.jpg" alt="" onclick="window.location.href='/products'">
            <p>Ta en titt på våre fantastiske <a href="/products">produkter</a></p>

        </main>
    </body>
    <footer>
       <mytags:Copyright since="2008">HVL</mytags:Copyright>
    </footer>
</html>
