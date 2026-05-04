<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cadastra Tipo</title>

<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap"
	rel="stylesheet">

</head>
<body>

	<div class="container">
		<div class="box">
			<h2>Gerenciamento de Mensagens</h2>

			<form action="<c:url value='/cadastraTipo'/>" method="post">


				<div style="display: flex; gap: 10px; align-items: flex-end;">

					<div class="input-group" style="flex: 1;">
						<label>ID:</label> <input type="number" name="id"
							placeholder="ID da mensagem" value="${mensagem.id}">
					</div>

					<button type="submit" name="acao" value="Buscar" class="btn"
						style="height: 42px;">Buscar</button>

				</div>

				<div class="input-group">
					<label>Conteúdo:</label> <input type="text" name="conteudo"
						 value="${mensagem.conteudo}">
				</div>


				<div class="input-group">
					<label>Tipo:</label> <input type="text" name="tipo" 
						value="${mensagem.tipo}">
				</div>

				<input type="hidden" name="redirect" value="${redirect}">

				<div
					style="display: flex; gap: 10px; flex-wrap: wrap; margin-top: 15px;">
					<button type="submit" name="acao" value="Inserir" class="btn">Inserir</button>
					<button type="submit" name="acao" value="Atualizar" class="btn">Atualizar</button>
					<button type="submit" name="acao" value="Excluir" class="btn">Excluir</button>
					<button type="submit" name="acao" value="Listar" class="btn">Listar</button>
				</div>
			</form>

			<!-- SAÍDA -->
			<c:if test="${not empty saida}">
				<div style="margin-top: 20px; color: lightgreen;">${saida}</div>
			</c:if>

			<!-- ERRO -->
			<c:if test="${not empty erro}">
				<div
					style="background: rgba(255, 0, 0, 0.15); border: 1px solid #e63946; border-radius: 4px; padding: 12px; color: #ff6b6b; margin-top: 20px;">
					${erro}</div>
			</c:if>

			<!-- LISTA -->
			<c:if test="${not empty mensagens}">
				<div style="margin-top: 25px; overflow-x: auto;">
					<table
						style="width: 100%; color: white; border-collapse: collapse;">
						<thead>
							<tr style="background: rgba(255, 255, 255, 0.1);">
								<th style="padding: 10px;">ID</th>
								<th style="padding: 10px;">Conteúdo</th>
								<th style="padding: 10px;">Tipo</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="m" items="${mensagens}">
								<tr style="border-bottom: 1px solid rgba(255, 255, 255, 0.05);">
									<td style="padding: 10px;">${m.id}</td>
									<td style="padding: 10px;">${m.conteudo}</td>
									<td style="padding: 10px;">${m.tipo}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>

			<!-- LOGOUT -->
			<div style="margin-top: 30px; text-align: right;">
				<a href="<c:url value='/logout'/>"
					style="color: white; text-decoration: none; font-size: 0.9rem; opacity: 0.7;">
					← Logout </a>
			</div>

		</div>
	</div>

</body>
</html>