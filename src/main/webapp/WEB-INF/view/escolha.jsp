<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Escolha sua Marca | Oráculo Gamer</title>

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>

    <div class="overlay"></div>
    <div class="box" style="text-align: center;">
        <h1>Escolha sua Marca</h1>
        <p class="lead">Descubra o que o oráculo revela...</p>

        <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 12px; margin-top: 20px;">
            <c:forEach var="v" items="${videogames}">
                <a href="<c:url value='/curiosidade/${v.id}'/>">
                    <button class="btn-light" style="width: 100%;">${v.nome}</button>
                </a>
            </c:forEach>
        </div>
    </div>
</body>
</html>