<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/template/header.jsp"/>

<main style="width: 100%; height: 95%; position: relative; top: 7.5%;">
    <h1>Erro ao realizar operação</h1>
    <ul>
        <c:forEach items="${errorMessages}" var="e">
            <li>${e}</li>
        </c:forEach>
    </ul>
</main>

<c:import url="/template/footer.jsp"/>
