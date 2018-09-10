<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="https://journaldev.com/jsp/tlds/mytags" prefix="mytags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Home</title>
        <link rel="stylesheet" href="public/style.css">
    </head>
    <body>
        <header>
            <a href="/home?langCode=no">Norsk</a>
            <a href="/home?langCode=en">Engelsk</a>
            <a href="/home?langCode=es">Espanjol</a>
        </header>
        <main>
            <h1>Javascripters AS</h1>
            <img class="logo" src="public/images/logo.jpg" alt="" onclick="window.location.href='/products'">
            <p><mytags:translation key="haveALookAtOurWonderful" langCode="${langCode}"></mytags:translation>
                <a href="/products"><mytags:translation key="products" langCode="${langCode}"></mytags:translation></a>
            </p>

        </main>
    </body>
    <footer>
       <mytags:Copyright since="2008">HVL</mytags:Copyright>
    </footer>
</html>
