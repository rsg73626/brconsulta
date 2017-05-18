<%-- 
    Document   : resultado
    Created on : 09/05/2017, 11:32:20
    Author     : 41583469
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach var="i" items="${restaurants}">
            ${i}
            <img src=${i.image}>
        </c:forEach>
    </body>
</html>
