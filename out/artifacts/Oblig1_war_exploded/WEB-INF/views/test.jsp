<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
        contentType="text/html;charset=UTF-8"
        language="java"
%>
<html>
    <head>
        <title>Kake</title>
    </head>
    <body>
        <div>${products.size()}</div>

        <c:forEach items="${products}" var="product">
            <div>${product.pName}</div>
        </c:forEach>
    </body>
</html>
