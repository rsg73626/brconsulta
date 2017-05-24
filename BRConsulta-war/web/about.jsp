<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${usuario == null}">
        <c:import url="/template/header.jsp"/>        
    </c:when>
    <c:otherwise>
        <c:import url="/template/header_post_login.jsp"/>      
    </c:otherwise>    
</c:choose>
<link href="css/about_style.css" rel="stylesheet" type="text/css"/>

<main>
    <hgroup>
        <h1>Sobre os Desenvolvedores</h1>
        <h3>Estudantes do segundo ano do curso de Ciênica da Computação</h3>
        <h3>Universidade Presbiteriana Mackenzie</h3>
    </hgroup>

    <div>
        <figure>
            <img src="" alt="Foto de Bruno Albuquerque">
            <figcaption>
                <h2>Bruno Albuquerque</h2>
                <p>Alguma coisa que o Bruno Albuquerque quis colocar aqui.</p>
            </figcaption>
        </figure>

        <figure>
            <img src="" alt="Foto de Renan S. Germano">
            <figcaption>
                <h2>Renan S. Germano</h2>
                <p>Alguma coisa que o Renan S. Germano quis colocar aqui.</p>
            </figcaption>
        </figure>
    </div>
</main>

<c:import url="/template/footer.jsp"/>
