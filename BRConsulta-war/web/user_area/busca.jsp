<%-- 
    Document   : busca
    Created on : 09/05/2017, 11:29:46
    Author     : 41583469
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busca Restaurantes</title>
    </head>
    <body>
        <form action="FrontController" method="POST">
            <input type="text" name="restaurat">
            
            <input type="hidden" name="ctrl" value="SearchRestaurant"/>
            
            <input type="submit" value="Buscar">
        </form>
    </body>
</html>
