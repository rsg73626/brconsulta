<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/template/header_post_login.jsp"/>
<link href="../css/home.css" rel="stylesheet" type="text/css"/>

    Buscar restaurante
        Visualizar lista de restaurantes
            Visualizar detalhes de restaurante
                Favoritar restaurante
                Visualizar galeria de fotos de restaurante
                </br>
                </br>
                ${usuario}
                
                <c:if test="${usuario_instagram != null}">
                    <img src="${usuario.profilePicture}" alt="Foto de perfil"/>
                </c:if>


<c:import url="/template/footer.jsp"/>
