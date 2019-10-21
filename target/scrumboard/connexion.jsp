<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page de connexion</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body style="background-color: #89609e;">
	<div style="display:flex; height:100vh;">
		<div style="margin: auto;">
			<!-- <img src="img/scrum-image.png" style="width: 300px;display: block;margin: auto;margin-bottom: 40px;" />-->
			<h1 style="color:#fff;text-align:center;">Connexion</h1>

			<form action="ConnexionServlet" method="post" style="background-color: rgba(255,255,255,0.4);padding: 30px 50px;border-radius: 40px;margin-top: 30px;">
				<div class="form-group">
					<label for="EMAIL">Email</label> <input type="email"
						class="form-control" name="EMAIL" placeholder="Entrez votre email">
				</div>
				<div class="form-group">
					<label for="MDP">Mot de passe</label> <input type="password"
						class="form-control" name="MDP"
						placeholder="Entrez votre mot de passe">
				</div>
				<button type="submit" class="btn btn-primary" style="margin: auto;display: block;background-color: #563d7c;border: none;">Connexion</button>
			</form>
		</div>
	</div>
</body>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</html>