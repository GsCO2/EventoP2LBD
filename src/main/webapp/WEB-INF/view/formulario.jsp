<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro - Fatec</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>

<div class="container">
    <div class="box">
        <h2>Cadastro de Candidato</h2>
        <form action="<c:url value='/candidato/salvar'/>" method="post">
            
            <div class="input-group">
                <label>Nome Completo:</label>
                <input type="text" name="nome_completo" required>
            </div>

            <div class="input-group">
                <label>E-mail:</label>
                <input type="email" name="email" required>
            </div>

            <div class="input-group">
                <label>Telefone Celular:</label>
                <input type="text" name="telefone_celular" required>
            </div>

            <div class="input-group">
                <label>Bairro:</label>
                <input type="text" name="bairro" required>
            </div>

            <div class="input-group">
                <label>Curso de Interesse:</label>
                <select name="curso_interesse">
                    <option value="ADS">Análise e Desenv. de Sistemas</option>
                    <option value="GE">Gestão Empresarial</option>
                    <option value="DSM">Desenv. de Software Multiplataforma</option>
                </select>
            </div>

            <button type="submit" class="btn">Finalizar Inscrição</button>
        </form>
    </div>
</div>

</body>
</html>