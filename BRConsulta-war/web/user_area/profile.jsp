<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/template/header_post_login.jsp"/>
<link href="<c:url value="/css/profile.css"/>" rel="stylesheet" type="text/css"/>
<main>
    <form action="FrontController" method="POST">
        <input type="text" required="required" id="nome_completo" name="nome_completo" value="${usuario.fullName}" title="Nome completo">

        <input type="date" required="required" id="dt_nasc" name="dt_nasc" placeholder="Data de Nascimento" title="Data de Nascimento">

        <input type="email" required="required" id="email" name="email" value="${usuario.email}" placeholder="E-mail" title="E-mail">

        <input type="text" required="required" id="usuario" name="usuario" value="${usuario.userName}" title="Nome de Usuário" readonly="readonly">

        <c:if test="${usuario_instagram == null}">
            <input type="password" required="required" id="senha" name="senha" placeholder="Senha" title="Senha">
            <input type="password" required="required" id="conf_senha" name="conf_senha" placeholder="Confirmação de Senha" title="Confirmação de Senha">
        </c:if>

        <input type="hidden" name="ctrl" value="Update${(usuario_instagram != null)?'Instagram':'Common'}Profile"/>

        <input type="submit" value="ALTERAR">
    </form>
    <a href="FrontController?ctrl=Unsubscribe">CANCELAR CADASTRO</a>
</main>

<c:import url="/template/footer.jsp"/>
