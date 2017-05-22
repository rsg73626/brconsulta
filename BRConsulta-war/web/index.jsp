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

<link href="css/style.css" rel="stylesheet" type="text/css"/>
<section>
            <article>
                <img src="..." alt="Ícone/Img representativa">
                
                <hgroup>
                    <h1>Título descritivo</h1>
                    <h3>Descrição detalhada</h3>
                    
                    <a href="signup.jsp" title="Registre-se em nosso site.">Registrar-se</a>
                </hgroup>
            </article>
            <article>
                <ul>
                    <li>
                        Bruno Albuquerque
                    </li>
                    <li>
                        Renan S. Germano
                    </li>
                </ul>
            </article>
            <article>
                <h1>Principais Funcionalidades: </h1>
                <figure>
                    <div>
                        <img src="images/search.ico" alt="Ícone de busca">
                        <figcaption>Busca de Restaurantes</figcaption>
                    </div>
                    <div>
                        <img src="images/gallery.png" alt="Ícone de fotos">
                        <figcaption>Galeria de Fotos de Restaurantes</figcaption>                  
                    </div>
                    <div>
                        <img src="images/favorite.png" alt="Ícone de favorito">
                        <figcaption>Lista de Restaurantes Favoritos</figcaption>                    
                    </div>
                </figure>
            </article>
        </section>

<c:import url="/template/footer.jsp"/>
