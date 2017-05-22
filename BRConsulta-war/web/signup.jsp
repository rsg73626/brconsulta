<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<c:import url="/template/header.jsp"/>
<link href="css/signup_style.css" rel="stylesheet" type="text/css"/>
<main>
    <form action="FrontController" method="POST">
        <input type="text" required="required" id="nome_completo" name="nome_completo" placeholder="Nome Completo">

        <input type="date" required="required" id="dt_nasc" name="dt_nasc" placeholder="Data de Nascimento">

        <input type="email" required="required" id="email" name="email" placeholder="E-mail">

        <input type="text" required="required" id="usuario" name="usuario" placeholder="Nome de Usuário">

        <input type="password" required="required" id="senha" name="senha" placeholder="Senha">

        <input type="password" required="required" id="conf_senha" name="conf_senha" placeholder="Confirmação de Senha">

        <input type="hidden" name="ctrl" value="Cadastro"/>

        <input type="submit" value="REGISTRAR">
    </form>
    
    ou
    
        <a href="https://api.instagram.com/oauth/authorize/?client_id=1631b13910b44f0a8b95f3c96b061470&redirect_uri=http://localhost:8080/BRConsulta-war/AuthenticationByInstagram&response_type=code">
            <button>INSTAGRAM</button>
    </a>
</main>

<c:import url="/template/footer.jsp"/>
