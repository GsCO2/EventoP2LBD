<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmação</title>
    
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="overlay"></div>

    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="box text-center shadow-lg rounded-4">
            
            <h2 class="display-5 fw-bold">Cadastro realizado!</h2>

            <p class="mt-4 fs-5">
                Você agora faz parte da nossa newsletter
            </p>

            <p class="mb-4">
                Em breve você receberá informações sobre os próximos vestibulares da Fatec ZL.
            </p>

            <a href="<c:url value='/'/>" class="btn btn-light btn-lg px-5">
                Voltar ao início
            </a>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>