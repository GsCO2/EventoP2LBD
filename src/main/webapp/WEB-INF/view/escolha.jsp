<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Escolha sua Marca | Oráculo Gamer</title>

    <!-- Fonte -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">

    <!-- CSS -->
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>

    <div class="overlay"></div>

    <div class="box" style="text-align: center;">

        <h1>Escolha sua Marca</h1>
        <p class="lead">Descubra o que o oráculo revela...</p>

        <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 12px; margin-top: 20px;">

            <a href="<c:url value='/oraculo/revelar/microsoft'/>">
                <button class="btn-light" style="width: 100%;">Microsoft</button>
            </a>

            <a href="<c:url value='/oraculo/revelar/sony'/>">
                <button class="btn-light" style="width: 100%;">Sony</button>
            </a>

            <a href="<c:url value='/oraculo/revelar/nintendo'/>">
                <button class="btn-light" style="width: 100%;">Nintendo</button>
            </a>

            <a href="<c:url value='/oraculo/revelar/sega'/>">
                <button class="btn-light" style="width: 100%;">Sega</button>
            </a>

        </div>

    </div>

</body>
</html>