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
<body style="background-color: #89609e;">

	<div class="container-fluid">
		<h1 style="text-align: center; color: #fff; margin: 30px 0 10px 0;">Scrumboard</h1>
		<h2
			style="text-align: center; color: #fff; margin-top: 0; font-size: 20px; margin-bottom: 50px;">${utilisateur.prenom}
			${utilisateur.nom}</h2>
		<c:if test="${sessionScope.utilisateur.isAdministrateur() == true}">
			<div id="barreOutils">
				<a id="ajouterTache">Ajouter une tache</a>
			</div>
		</c:if>

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
												<p>${tache.libelleTache}</p>
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
													<p>${tache.libelleTache}</p>
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
													<p>${tache.libelleTache}</p>
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
										test="${ (tache.colonne.idColonne == 19) && (tache.utilisateur.idUtilisateur == utilisateur.idUtilisateur)}">
										<article class="kanban-entry grab" id="item${tache.idTache}"
											tache-id="${tache.idTache}"
											<c:if
										test="${tache.utilisateur.idUtilisateur == utilisateur.idUtilisateur}">draggable="true"</c:if>
											<c:if test="${sessionScope.utilisateur.isAdministrateur() == true}">draggable="true"</c:if>>
											<div
												class="couleur-type-tache ${tache.typeTache.description}"></div>
											<div class="kanban-entry-inner">
												<div class="kanban-label">
													<p>${tache.libelleTache}</p>
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
								</thead>
								<tbody>
									<tr>
										<td>20/03/2019</td>
										<td>TO DO</td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Supprimer</button>
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
						<form id="formulaireAjoutTache">
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
</script>
<script>
	$("#ENREGISTRER").click(function() {
		var form = $('#formulaireAjoutTache');
		$.ajax({
			type : 'POST', // Le type de la requête HTTP.
			url : 'IndexServlet', // La ressource ciblée
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
						$('input[name="LIBELLETACHE"]').val(data.libelleTache);
						$('select[name="UTILISATEUR"]').append(
								new Option(data.utilisateur.prenom + " "
										+ data.utilisateur.nom,
										data.utilisateur.idUtilisateur));
						$('select[name="TYPETACHE"]').append(
								new Option(data.typeTache.libelle,
										data.typeTache.idTypeTache));
						$('select[name="COLONNE"]').append(
								new Option(data.colonne.libelleColonne,
										data.colonne.idColonne));
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

					}

				});
			});
</script>


</html>
