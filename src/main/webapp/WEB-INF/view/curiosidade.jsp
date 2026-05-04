<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Oráculo Revela | ${marca}</title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap"
	rel="stylesheet">
</head>
<body
	style="display: flex; flex-direction: column; min-height: 100vh; align-items: center; justify-content: center;">

	<div class="overlay"></div>

	<div class="container"
		style="z-index: 10; width: 100%; display: flex; justify-content: center;">
		<div class="box"
			style="max-width: 600px; text-align: center; padding: 40px;">

			<h2 style="text-transform: uppercase; letter-spacing: 2px;">${marca}</h2>

			<hr
				style="border: 0; height: 1px; background: rgba(255, 255, 255, 0.3); margin: 20px 0;">

			<p class="lead"
				style="font-size: 1.2rem; line-height: 1.6; margin-bottom: 30px;">
				<c:choose>
					<c:when test="${not empty mensagem}">
                        ${mensagem}
                    </c:when>
					<c:otherwise>
                        O oráculo não encontrou registros para esta marca.
                    </c:otherwise>
				</c:choose>
			</p>

			<div
				style="background: rgba(255, 255, 255, 0.1); padding: 15px; border-radius: 10px;">
				<p style="margin: 0; font-size: 0.9rem;">
					Você será levado para a página de cadastro para o newsletter FATEC
					em <span id="timer"
						style="font-weight: bold; color: #fff; font-size: 1.1rem;">15</span>
					segundos...
				</p>
			</div>

		</div>
	</div>

	<script>
        let seconds = 15;
        const display = document.getElementById('timer');

        const countdown = setInterval(() => {
            seconds--;
            if (seconds >= 0) {
                display.innerText = seconds;
            }
            if (seconds === 0) {
                clearInterval(countdown);
                window.location.href = "<c:url value='/cadastro'/>";
            }
        }, 1000);
    </script>

</body>
</html>