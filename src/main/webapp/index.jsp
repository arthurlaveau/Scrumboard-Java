<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tableau de bord</title>
<link href="css/style.css" rel="stylesheet">
<link href="css/srumboard.css" rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

</head>
<body style="background-color: #dadada;" <c:if test="${sessionScope.utilisateur.isAdministrateur() == true}">class="panel-administrateur"</c:if>>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="#"
			style="padding-top: 0; padding-bottom: 0;">Projet Scrumboard</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor02" aria-controls="navbarColor02"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor02">
			<p><span style="text-transform: capitalize;">${utilisateur.prenom}</span> <span style="text-transform: uppercase;">${utilisateur.nom}</span></p>
			<c:if test="${sessionScope.utilisateur.isAdministrateur() == true}">
				<div id="barreOutils">
					<a id="ajouterUtilisateur">Ajouter un utilisateur</a>
					<a id="ajouterTache">Ajouter une tache</a>
				</div>
			</c:if>
			<form action="DeconnexionServlet" method="post" style="margin: auto 0 auto 20px !important;"><input id="DECONNEXION" type="submit" class="btn btn-danger" value="Déconnexion"></form>
		</div>
	</nav>

	<div class="container-fluid" style="margin-top: 50px;">
		<div style="display: flex;">
			<div id="sortableKanbanBoards" class="row" style="margin: 0 auto;">
				<div class="panel panel-primary kanban-col">
					<div class="panel-heading">
						TO DO <i class="fa fa-2x fa-plus-circle pull-right"></i>
					</div>
					<div class="panel-body">

						<div id="TODO" id-colonne="16" class="kanban-centered">
							<c:forEach items="${taches}" var="tache">
								<c:if test="${tache.colonne.idColonne == 16}">
									<article class="kanban-entry grab" id="item${tache.idTache}"
										tache-id="${tache.idTache}"
										<c:if
										test="${tache.utilisateur.idUtilisateur == utilisateur.idUtilisateur}">draggable="true"</c:if>
										<c:if test="${sessionScope.utilisateur.isAdministrateur() == true}">draggable="true"</c:if>>
										<div class="couleur-type-tache ${tache.typeTache.description}"></div>
										<div class="kanban-entry-inner">
											<div class="kanban-label">
												<p style="min-height: 30px;"><span class="util-attribue"><span class="prenom">${tache.utilisateur.prenom}</span> <span class="nom">${tache.utilisateur.nom}</span></span>${tache.libelleTache}</p>
											</div>
										</div>
									</article>
								</c:if>
							</c:forEach>

						</div>
					</div>
				</div>


				<div id="sortableKanbanBoards" class="row" style="margin: 0 auto;">
					<div class="panel panel-primary kanban-col">
						<div class="panel-heading">
							IN PROGRESS <i class="fa fa-2x fa-plus-circle pull-right"></i>
						</div>
						<div class="panel-body">

							<div id="PROGRESSING" id-colonne="17" class="kanban-centered">
								<c:forEach items="${taches}" var="tache">
									<c:if test="${tache.colonne.idColonne == 17}">
										<article class="kanban-entry grab" id="item${tache.idTache}"
											tache-id="${tache.idTache}"
											<c:if
										test="${tache.utilisateur.idUtilisateur == utilisateur.idUtilisateur}">draggable="true"</c:if>
											<c:if test="${sessionScope.utilisateur.isAdministrateur() == true}">draggable="true"</c:if>>
											<div
												class="couleur-type-tache ${tache.typeTache.description}"></div>
											<div class="kanban-entry-inner">
												<div class="kanban-label">
													<p style="min-height: 30px;"><span class="util-attribue"><span class="prenom">${tache.utilisateur.prenom}</span> <span class="nom">${tache.utilisateur.nom}</span></span>${tache.libelleTache}</p>
												</div>
											</div>
										</article>
									</c:if>
								</c:forEach>

							</div>
						</div>
					</div>



					<div class="panel panel-primary kanban-col">
						<div class="panel-heading">
							TO VERIFY <i class="fa fa-2x fa-plus-circle pull-right"></i>
						</div>
						<div class="panel-body">
							<div id="VERIFYING" id-colonne="18" class="kanban-centered">

								<c:forEach items="${taches}" var="tache">
									<c:if test="${tache.colonne.idColonne == 18}">
										<article class="kanban-entry grab" id="item${tache.idTache}"
											tache-id="${tache.idTache}"
											<c:if
										test="${tache.utilisateur.idUtilisateur == utilisateur.idUtilisateur}">draggable="true"</c:if>
											<c:if test="${sessionScope.utilisateur.isAdministrateur() == true}">draggable="true"</c:if>>
											<div
												class="couleur-type-tache ${tache.typeTache.description}"></div>
											<div class="kanban-entry-inner">
												<div class="kanban-label">
													<p style="min-height: 30px;"><span class="util-attribue"><span class="prenom">${tache.utilisateur.prenom}</span> <span class="nom">${tache.utilisateur.nom}</span></span>${tache.libelleTache}</p>
												</div>
											</div>
										</article>
									</c:if>
								</c:forEach>

							</div>
						</div>
					</div>



					<div class="panel panel-primary kanban-col"
						style="margin-right: 0 !important;">
						<div class="panel-heading">
							DONE <i class="fa fa-2x fa-plus-circle pull-right"></i>
						</div>
						<div class="panel-body">
							<div id="DONE" id-colonne="19" class="kanban-centered">

								<c:forEach items="${taches}" var="tache">
									<c:if
										test="${tache.colonne.idColonne == 19}">
										<article class="kanban-entry grab" id="item${tache.idTache}"
											tache-id="${tache.idTache}"
											<c:if
										test="${tache.utilisateur.idUtilisateur == utilisateur.idUtilisateur}">draggable="true"</c:if>
											<c:if test="${sessionScope.utilisateur.isAdministrateur() == true}">draggable="true"</c:if>>
											<div
												class="couleur-type-tache ${tache.typeTache.description}"></div>
											<div class="kanban-entry-inner">
												<div class="kanban-label">
													<p style="min-height: 30px;"><span class="util-attribue"><span class="prenom">${tache.utilisateur.prenom}</span> <span class="nom">${tache.utilisateur.nom}</span></span>${tache.libelleTache}</p>
												</div>
											</div>
										</article>
									</c:if>
								</c:forEach>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal -->
		<div class="modal" id="detailsModal" tabindex="-1" role="dialog"
			aria-labelledby="ajoutModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="ajoutModalLabel">Détails de la
							tâche</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-group">
								<label for="LIBELLETACHE" class="col-form-label">Libelle</label>
								<input type="text" class="form-control" name="LIBELLETACHE"
									disabled>
							</div>
							<div class="form-group">
								<label for="UTILISATEUR">Utilisateur</label> <select
									class="form-control" name="UTILISATEUR" disabled>
								</select>
							</div>
							<div class="form-group">
								<label for="TYPETACHE">Type de tache</label> <select
									class="form-control" name="TYPETACHE" disabled>
								</select>
							</div>
							<div class="form-group">
								<label for="COLONNE">Colonne</label> <select
									class="form-control" name="COLONNE" disabled>
								</select>
							</div>
							
							<table class="table historique">
								<thead>
									<tr>
										<th scope="col">Date</th>
										<th scope="col">Colonne</th>
									</tr>
									<tr id="dateCreationHistorique">
									</tr>
								</thead>
								<tbody id="historiqueTache">

								</tbody>
							</table>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Fermer</button>
					</div>
				</div>
			</div>
		</div>

		<div class="modal" id="ajoutModal" tabindex="-1" role="dialog"
			aria-labelledby="ajoutModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="ajoutModalLabel">Ajouter une
							tache</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="formulaireAjoutTache" autocomplete="off">
							<div class="form-group">
								<label for="LIBELLETACHE" class="col-form-label">Libelle</label>
								<input id="LIBELLETACHE" type="text" class="form-control"
									name="LIBELLETACHE">
							</div>
							<div class="form-group">
								<label for="UTILISATEUR">Utilisateur</label> <select
									id="UTILISATEUR" class="form-control" name="UTILISATEUR">
									<option value="">- Sélectionner -</option>
									<c:forEach items="${utilisateurs}" var="utilisateur">
										<option value="${utilisateur.idUtilisateur}">${utilisateur.prenom}
											${utilisateur.nom}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="TYPETACHE">Type de tache</label> <select
									id="TYPETACHE" class="form-control" name="TYPETACHE">
									<option value="">- Sélectionner -</option>
									<c:forEach items="${typesTaches}" var="typesTache">
										<option value="${typesTache.idTypeTache}">${typesTache.libelle}</option>
									</c:forEach>
								</select>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Annuler</button>
						<button id="ENREGISTRER" type="button" class="btn btn-primary">Enregistrer</button>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal" id="ajoutUtilisateurModal" tabindex="-1" role="dialog"
			aria-labelledby="ajoutModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="ajoutModalLabel">Ajouter un
							utilisateur</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="formulaireAjoutUtilisateur" autocomplete="off">
							<div class="form-group">
								<label for="NOM" class="col-form-label">Nom</label>
								<input id="NOM" type="text" class="form-control"
									name="NOM">
							</div>
							<div class="form-group">
								<label for="PRENOM" class="col-form-label">Prénom</label>
								<input id="PRENOM" type="text" class="form-control"
									name="PRENOM">
							</div>
							<div class="form-group">
								<label for="PSEUDO" class="col-form-label">Pseudo</label>
								<input id="PSEUDO" type="text" class="form-control"
									name="PSEUDO">
							</div>
							<div class="form-group">
								<label for="EMAIL" class="col-form-label">Email</label>
								<input id="EMAIL" type="email" class="form-control"
									name="EMAIL">
							</div>
							<div class="form-group">
								<label for="MDP" class="col-form-label">Mot de passe</label>
								<input id="MDP" type="password" class="form-control"
									name="MDP">
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Annuler</button>
						<button id="AJOUTERUTIL" type="button" class="btn btn-primary">Ajouter</button>
					</div>
				</div>
			</div>
		</div>
</body>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script>
	$(function() {
		var kanbanCol = $('.panel-body');
		kanbanCol.css('max-height', (window.innerHeight - 150) + 'px');

		var kanbanColCount = parseInt(kanbanCol.length);
		$('.container-fluid').css('min-width', (kanbanColCount * 350) + 'px');

		draggableInit();

		$('.panel-heading').click(function() {
			var $panelBody = $(this).parent().children('.panel-body');
			$panelBody.slideToggle();
		});
	});

	function draggableInit() {
		var sourceId;

		$('[draggable=true]').bind(
				'dragstart',
				function(event) {
					sourceId = $(this).parent().attr('id');
					event.originalEvent.dataTransfer.setData("text/plain",
							event.target.getAttribute('id'));
				});

		$('.panel-body').bind('dragover', function(event) {
			event.preventDefault();
		});

		$('.panel-body').bind(
				'drop',
				function(event) {
					var children = $(this).children();
					var idColonne = children.attr('id-colonne');
					var targetId = children.attr('id');

					if (sourceId != targetId) {
						var elementId = event.originalEvent.dataTransfer
								.getData("text/plain");
						var idTache = $('#' + elementId).attr("tache-id");

						// Post data
						setTimeout(function() {
							var element = document.getElementById(elementId);
							children.prepend(element);
							event.preventDefault();

						}, 1);

						event.preventDefault();
						$.ajax({
							type : 'POST',
							url : 'MouvementServlet',
							dataType : "json",
							data : {
								idColonne : idColonne,
								idTache : idTache
							},
							success : function() {
								location.reload()
							}
						});

					}

				});
	}
</script>


<script>
	$("#ajouterTache").click(function() {
		$('#ajoutModal').modal('show');
	});
	$("#ajouterUtilisateur").click(function() {
		$('#ajoutUtilisateurModal').modal('show');
	});
</script>

<script>
	$("#ENREGISTRER").click(function() {
		var form = $('#formulaireAjoutTache');
		$.ajax({
			type : 'POST', // Le type de la requête HTTP.
			url : 'TacheServlet', // La ressource ciblée
			data : form.serialize(),

			success : function() {
				location.reload()
			}
		});
	});
</script>
<script>
	$("#AJOUTERUTIL").click(function() {
		var form = $('#formulaireAjoutUtilisateur');
		$.ajax({
			type : 'POST', // Le type de la requête HTTP.
			url : 'UtilisateurServlet', // La ressource ciblée
			data : form.serialize(),

			success : function() {
				location.reload()
			}
		});
	});
</script>

<script>
	$("article.kanban-entry.grab").dblclick(
			function() {
				$('#detailsModal').modal('show');
				var idTache = $(this).attr("tache-id");
				$.ajax({
					type : 'GET', // Le type de la requête HTTP.
					url : "DetailServlet",
					data : {
						"idTache" : idTache
					},
					success : function(data) {
						console.log(data);
						$("#detailsModal #dateCreationHistorique").children().remove();

						$('#detailsModal input[name="LIBELLETACHE"]').val(data.libelleTache);
						$('#detailsModal select[name="UTILISATEUR"]').append(
								new Option(data.utilisateur.prenom + " "
										+ data.utilisateur.nom,
										data.utilisateur.idUtilisateur));
						$('#detailsModal select[name="TYPETACHE"]').append(
								new Option(data.typeTache.libelle,
										data.typeTache.idTypeTache));
						$('#detailsModal select[name="COLONNE"]').append(
								new Option(data.colonne.libelleColonne,
										data.colonne.idColonne));
						$('#detailsModal #dateCreationHistorique').append(
								'<td>' + data.dateCreation + '</td><td>TO DO</td>');
					}

				});
				$.ajax({
					type : 'GET', // Le type de la requête HTTP.
					url : "HistoriqueServlet",
					data : {
						"idTache" : idTache
					},
					success : function(data) {
						console.log(data);
						$("#detailsModal #historiqueTache").children().remove();
						$.each(data, function(i, val) {
							$('#detailsModal #historiqueTache').append(
									'<tr><td>' + val.dateCreation + '</td><td>'
											+ val.colonne.libelleColonne
											+ '</td></tr>');
						});
					}

				});
			});
</script>
<script>
$( document ).ready(function() {
	$( "span.util-attribue > span.prenom" ).each(function( index ) {
		var prenom = $(this).text();
		$(this).html(prenom.charAt(0).toUpperCase());
	});
	$( "span.util-attribue > span.nom" ).each(function( index ) {
		var nom = $(this).text();
		$(this).html(nom.charAt(0).toUpperCase());
	});
});
</script>

</html>
