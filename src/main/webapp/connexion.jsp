<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page de connexion</title>
<link href="css/connexion.css" rel="stylesheet">
</head>
<body>
	<div class="v-center-wrap">
		<div class="v-center-stuff">

			<div class="sign-in v-center-wrap" data-finger="false">
				<div class="v-center-stuff half">
					<form action="ConnexionServlet" method="post">
						<h1 class="fade">Se connecter</h1>
						<label for="EMAIL" class="fade">Email</label> <span class="fade">
							<input type="email" id="email" name="EMAIL"
							placeholder="Entrez votre email" required>
						</span> <label for="MDP" class="fade">Mot de passe</label> <span
							class="fade"> <input type="password" id="pass" name="MDP"
							placeholder="Entrez votre mot de passe" required>
						</span> <span class="fade">
							<button type="submit" class="btn btn--green">Connexion</button>
						</span>
					</form>


				</div>
				<div class="v-center-stuff half">
					<div class="caption-finger">
						<h1 class="fade">Scrumboard</h1>
						<span class="fingerprint"></span> <span class="fade">
						</span>
					</div>
				</div>

			</div>

		</div>
	</div>
</body>
</html>