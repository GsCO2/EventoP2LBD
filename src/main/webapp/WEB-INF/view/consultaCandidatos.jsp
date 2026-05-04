<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Painel Administrativo - Fatec</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
</head>
<body class="admin-body">

<div class="container" style="max-width: 1200px; margin-top: 50px;">
    <div class="box" style="padding: 40px;">
        <h2>Painel Administrativo</h2>
        <p>Gerenciamento e consulta de candidatos inscritos.</p>
        
        <hr style="margin: 20px 0; border: 0; border-top: 1px solid rgba(255,255,255,0.1);">


        <div class="filtros-container" style="display: flex; gap: 10px; flex-wrap: wrap; margin-bottom: 25px;">
            <a href="?login=${login}&senha=${senha}&filtro=ordemCurso" class="btn" style="flex: 1; text-align: center; font-size: 0.8rem;">Ordenar por Curso</a>
            <a href="?login=${login}&senha=${senha}&filtro=ordemBairro" class="btn" style="flex: 1; text-align: center; font-size: 0.8rem;">Ordenar por Bairro</a>
            <a href="?login=${login}&senha=${senha}&filtro=top10Primeiros" class="btn" style="flex: 1; text-align: center; font-size: 0.8rem;">10 Primeiros</a>
            <a href="?login=${login}&senha=${senha}&filtro=top10Ultimos" class="btn" style="flex: 1; text-align: center; font-size: 0.8rem;">10 Últimos</a>
            <a href="?login=${login}&senha=${senha}" class="btn" style="flex: 0.5; text-align: center; background: #666; font-size: 0.8rem;">Limpar</a>
        </div>

        <form action="" method="get" class="search-form" style="display: flex; gap: 10px; margin-bottom: 30px; align-items: flex-end;">
            <input type="hidden" name="login" value="${login}">
            <input type="hidden" name="senha" value="${senha}">
            
            <div class="input-group" style="flex: 1; margin-bottom: 0;">
                <label>Filtrar por:</label>
                <select name="filtro" style="width: 100%; padding: 10px; border-radius: 5px; background: rgba(255,255,255,0.9);">
                    <option value="curso">Curso (Ex: ADS)</option>
                    <option value="bairro">Bairro</option>
                </select>
            </div>

            <div class="input-group" style="flex: 2; margin-bottom: 0;">
                <label>Valor da busca:</label>
                <input type="text" name="valor" placeholder="Digite o termo de busca..." required style="width: 100%; padding: 10px;">
            </div>

            <button type="submit" class="btn" style="padding: 10px 25px; height: 42px;">Buscar</button>
        </form>

        <div class="table-responsive" style="overflow-x: auto;">
            <table class="table-custom" style="width: 100%; border-collapse: collapse; color: white;">
                <thead>
                    <tr style="background: rgba(255,255,255,0.1); text-align: left;">
                        <th style="padding: 15px;">Nome</th>
                        <th style="padding: 15px;">E-mail</th>
                        <th style="padding: 15px;">Curso</th>
                        <th style="padding: 15px;">Bairro</th>
                        <th style="padding: 15px;">Data/Hora</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="c" items="${lista}">
                        <tr style="border-bottom: 1px solid rgba(255,255,255,0.05);">
                            <td style="padding: 12px 15px;">${c.nome_completo}</td>
                            <td style="padding: 12px 15px;">${c.email}</td>
                            <td style="padding: 12px 15px;">
                                <span class="badge" style="background: rgba(255,255,255,0.2); padding: 2px 8px; border-radius: 4px; font-size: 0.8rem;">
                                    ${c.curso_interesse}
                                </span>
                            </td>
                            <td style="padding: 12px 15px;">${c.bairro}</td>
                            <td style="padding: 12px 15px; font-size: 0.85rem; color: #ccc;">
                                <fmt:parseDate value="${c.data_hora_cadastro}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDate" type="both" />
                                <fmt:formatDate value="${parsedDate}" pattern="dd/MM/yyyy HH:mm" />
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty lista}">
                        <tr>
                            <td colspan="5" style="padding: 30px; text-align: center; color: #999;">Nenhum candidato encontrado.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>

        <div style="margin-top: 30px; text-align: right;">
            <a href="<c:url value='/candidato/cadastro'/>" style="color: white; text-decoration: none; font-size: 0.9rem; opacity: 0.7;">← Voltar ao Cadastro</a>
        </div>
    </div>
</div>

</body>
</html>