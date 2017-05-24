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
    <div>
        <figure>
            <img src="<c:url value="/images/bruno_profile.jpg"/>" alt="Foto de Bruno Albuquerque" class="profile_pic">
            <figcaption>
                <h2>Bruno Albuquerque</h2>
                <a href="https://github.com/brunoalbrito" title="Link para o Github" target="_brank">
                    <img src="<c:url value="/images/GitHub-Mark-64px.png"/>" alt="Logo do Github">
                </a>
            </figcaption>
        </figure>

        <figure>
            <img src="<c:url value="/images/renan_profile.jpg"/>" alt="Foto de Renan S. Germano" class="profile_pic">
            <figcaption>
                <h2>Renan S. Germano</h2>
                <a href="https://github.com/rsg73626" title="Link para o Github" target="_brank">
                    <img src="<c:url value="/images/GitHub-Mark-64px.png"/>" alt="Logo do Github">
                </a>
            </figcaption>
        </figure>
    </div>
</main>

<c:import url="/template/footer.jsp"/>