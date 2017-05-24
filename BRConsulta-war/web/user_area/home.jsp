<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="h" uri="/WEB-INF/tlds/restauranttag"%>
<c:import url="/template/header_post_login.jsp"/>
<link href="<c:url value="/css/home.css"/>" rel="stylesheet" type="text/css"/>

<main>
    <form action="<c:url value="/FrontController"/>" method="POST">
        <input type="text" name="restaurat">

        <input type="hidden" name="ctrl" value="SearchRestaurant"/>

        <input type="submit" value="Buscar">
    </form>
<!--    Buscar restaurante
    Visualizar lista de restaurantes
    Visualizar detalhes de restaurante
    Favoritar restaurante
    Visualizar galeria de fotos de restaurante-->
    </br>
    </br>
    ${usuario}

    <c:if test="${usuario_instagram != null}">
        <img id="instaphoto" src="${usuario.profilePicture}" alt="Foto de perfil"/>
    </c:if>
    <c:choose>
        <c:when test="${restaurants != null}">
            <h:Rest items="${restaurants}" context="${pageContext.request.contextPath}" />            
        </c:when>
    </c:choose>
</main>


<c:import url="/template/footer.jsp"/>
