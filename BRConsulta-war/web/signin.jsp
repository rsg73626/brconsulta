<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<c:import url="/template/header.jsp"/>
<link href="css/signin_style.css" rel="stylesheet" type="text/css"/>

<main>
    <form method="post" action="FrontController">
        <label for="usuario">Nome de Usuário: </label>
        <input type="text" required="required" id="usuario" name="usuario">

        <label for="senha">Senha: </label>
        <input type="password" required="required" id="senha" name="senha">
        
        <input type="hidden" name="ctrl" value="Login"/>
        
        <input type="submit" value="LOGAR">
    </form>
    
    ou
    
    <a href="https://api.instagram.com/oauth/authorize/?client_id=1631b13910b44f0a8b95f3c96b061470&redirect_uri=http://localhost:8080/BRConsulta-war/AuthenticationByInstagram&response_type=code">
        <button>INSTAGRAM</button>
    </a>
    
</main>

<c:import url="/template/footer.jsp"/>
