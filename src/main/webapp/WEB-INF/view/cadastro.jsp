<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">

<script>
	function validarTelefone(input) {
		input.value = input.value.replace(/\D/g, '');
		if (input.value.length > 11) {
			input.value = input.value.slice(0, 11);
		}
	}

	function validarForm(form) {
		const checkbox = form.aceitacao;

		if (!checkbox.checked) {
			checkbox.setCustomValidity("Para cadastro é necessário aceitar.");
			checkbox.reportValidity();
			return false;
		}

		return true;
	}
</script>
</head>
<body>

	<div class="container">
		<div class="box">
			<h2>Cadastro de Candidato</h2>
			<form action="<c:url value='/cadastro'/>" method="post"
				onsubmit="return validarForm(this)">

				<div class="input-group">
					<label>Nome Completo:</label> <input type="text" name="nome"
						required>
				</div>

				<div class="input-group">
					<label>E-mail:</label> <input type="email" name="email" required>
				</div>

				<div class="input-group">
					<label>Telefone Celular:</label> <input type="text" name="celular"
						placeholder="11999999999" maxlength="11" pattern="[0-9]{11}"
						title="Digite exatamente 11 números (DD + número)"
						oninput="validarTelefone(this)" required>
				</div>

				<div class="input-group">
					<label>Bairro:</label> <input type="text" name="bairro" required>
				</div>

				<div class="input-group">
					<label>Curso de Interesse:</label> <select name="idCurso" required>
						<c:forEach var="curso" items="${cursos}">
							<option value="${curso.id}">${curso.nome}</option>
						</c:forEach>
					</select>
				</div>

				<div class="input-group"
					style="display: flex; align-items: center; gap: 8px;">
					<input type="checkbox" name="aceitacao" id="aceitacao"
						onchange="this.setCustomValidity('')"> <label
						for="concorda"> Concordo em receber mensagens da Fatec ZL
						sobre vestibular </label>
				</div>
				<c:if test="${not empty erro}">
					<div
						style="background: rgba(255, 0, 0, 0.15); border: 1px solid #e63946; border-radius: 4px; padding: 12px 16px; color: #ff6b6b; margin-bottom: 16px;">
						${erro}</div>
				</c:if>
				<button type="submit" class="btn">Finalizar Inscrição</button>
			</form>
		</div>
	</div>

</body>
</html>