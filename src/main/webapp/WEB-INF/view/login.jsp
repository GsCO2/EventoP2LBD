<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body class="admin-body">

<div class="container">
    <div class="box">
        <h2>Acesso Restrito</h2>
        <p>Identifique-se para acessar o painel.</p>

        <c:if test="${not empty erro}">
            <div style="color: #ff4d4d; margin-bottom: 15px; font-size: 0.9rem;">
                ${erro}
            </div>
        </c:if>

        <form action="<c:url value='/login'/>" method="post">
            <div class="input-group">
                <label for="login">Usuário</label>
                <input type="text" id="login" name="login" required placeholder="Digite seu login">
            </div>

            <div class="input-group">
                <label for="senha">Senha</label>
                <input type="password" id="senha" name="senha" required placeholder="Digite sua senha">
            </div>

            <button type="submit" class="btn">Entrar no Painel</button>
        </form>
        
        <div style="margin-top: 20px; text-align: center;">
            <a href="<c:url value='/'/>" style="color: #ccc; text-decoration: none; font-size: 0.8rem;">Voltar ao Início</a>
        </div>
    </div>
</div>

</body>
</html>