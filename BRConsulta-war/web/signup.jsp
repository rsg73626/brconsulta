<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<c:import url="/template/header.jsp"/>
<link href="css/signup_style.css" rel="stylesheet" type="text/css"/>
<main>
    <form action="FrontController" method="POST">
        <label for="nome_completo">Nome Completo: </label>
        <input type="text" required="required" id="nome_completo" name="nome_completo">

        <label for="dt_nasc">Data de Nascimento: </label>
        <input type="date" required="required" id="dt_nasc" name="dt_nasc">

        <label for="email">E-mail: </label>
        <input type="email" required="required" id="email" name="email">

        <label for="usuario">Nome de Usuário: </label>
        <input type="text" required="required" id="usuario" name="usuario">

        <label for="senha">Senha: </label>
        <input type="password" required="required" id="senha" name="senha">

        <label for="conf_senha">Confirmarção de Senha: </label>
        <input type="password" required="required" id="conf_senha" name="conf_senha">

        <input type="hidden" name="ctrl" value="Cadastro"/>

        <input type="submit" value="REGISTRAR">
    </form>
    
    ou
    
        <a href="https://api.instagram.com/oauth/authorize/?client_id=1631b13910b44f0a8b95f3c96b061470&redirect_uri=http://localhost:8080/BRConsulta-war/AuthenticationByInstagram&response_type=code">
            <button>Instagram</button>
    </a>
</main>

<c:import url="/template/footer.jsp"/>
