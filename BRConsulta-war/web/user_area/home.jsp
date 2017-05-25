<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="h" uri="/WEB-INF/tlds/restauranttag"%>
<c:import url="/template/header_post_login.jsp"/>
<link href="<c:url value="/css/home.css"/>" rel="stylesheet" type="text/css"/>
<section>
    <article>
        <form action="<c:url value="/FrontController"/>" method="POST">
            <input type="text" name="restaurat">
            <input type="hidden" name="ctrl" value="SearchRestaurant"/>
            <input type="submit" value="Buscar">
        </form>
    </article>

    <article>
        <c:if test="${restaurants != null}">
            <h:Rest items="${restaurants}" context="${pageContext.request.contextPath}" user="${(usuario_instagram != null)?true:false}"/>            
        </c:if>
    </article>
</section>
