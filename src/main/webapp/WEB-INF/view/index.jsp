<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="overlay"></div>
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="box text-center p-5 shadow-lg rounded-4" style="background: rgba(0,0,0,0.8); color: white; z-index: 10;">
            <h2 class="display-4 fw-bold">Oráculo</h2>

            <a href="<c:url value='/escolha'/>" class="btn btn-light btn-lg mt-4 px-5">
                Iniciar
            </a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>