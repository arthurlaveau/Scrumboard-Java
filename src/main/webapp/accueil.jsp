<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
	<!-- <div id="test">
		<table>
			<tr>
				<td>ID</td>
				<td>Email</td>
				<td>Niveau</td>
				<td>Ville</td>
			</tr>
			<c:forEach items="${utilisateurs}" var="joueur">
				<tr>
					<td>${utilisateur.email}</td>
					<td>${utilisateur.motDePasse}</td>
					<td>${utilisateur.niveau.nom}</td>
					<td>${utilisateur.ville.nom}</td>
				</tr>
			</c:forEach>
		</table>
	</div>-->
	<div class="container-fluid">
		<h1 style="text-align: center; color: #fff; margin: 30px 0;">Projet
			Scumboard</h1>
		<div id="barreOutils">
			<a id="ajouterTache">Ajouter une tache</a>
		</div>
		<div style="display: flex;">
			<div id="sortableKanbanBoards" class="row" style="margin: auto;">
				<div class="panel panel-primary kanban-col">
					<div class="panel-heading">
						TO DO <i class="fa fa-2x fa-plus-circle pull-right"></i>
					</div>
					<div class="panel-body">

						<div id="TODO" class="kanban-centered">
							<article class="kanban-entry grab" id="item1" draggable="true">
								<div class="kanban-entry-inner">
									<div class="kanban-label">
										<h2>
											<a href="#">Art Ramadani</a> <span>posted a status
												update</span>
										</h2>
										<p>Tolerably earnestly middleton extremely distrusts she
											boy now not. Add and offered prepare how cordial two promise.
											Greatly who affixed suppose but enquire compact prepare all
											put. Added forth chief trees but rooms think may.</p>
									</div>
								</div>
							</article>

							<article class="kanban-entry grab" id="item2" draggable="true">
								<div class="kanban-entry-inner">
									<div class="kanban-label">
										<h2>
											<a href="#">Job Meeting</a>
										</h2>
										<p>
											You have a meeting at <strong>Laborator Office</strong>
											Today.
										</p>
									</div>
								</div>
							</article>

							<article class="kanban-entry grab" id="item3" draggable="true">
								<div class="kanban-entry-inner">
									<div class="kanban-label">
										<h2>
											<a href="#">Arlind Nushi</a> <span>checked in at</span> <a
												href="#">Laborator</a>
										</h2>

										<blockquote>Great place, feeling like in home.</blockquote>
									</div>
								</div>
							</article>

							<article class="kanban-entry grab" id="item4" draggable="true">
								<div class="kanban-entry-inner">
									<div class="kanban-label">
										<h2>
											<a href="#">Arber Nushi</a> <span>changed his</span> <a
												href="#">Profile Picture</a>
										</h2>

										<blockquote>Pianoforte principles our unaffected
											not for astonished travelling are particular.</blockquote>

										<img
											src="http://themes.laborator.co/neon/assets/images/timeline-image-3.png"
											class="img-responsive img-rounded full-width">
									</div>
								</div>
							</article>

						</div>
					</div>
				</div>


				<div id="sortableKanbanBoards" class="row" style="margin: auto;">
					<div class="panel panel-primary kanban-col">
						<div class="panel-heading">
							IN PROGRESS <i class="fa fa-2x fa-plus-circle pull-right"></i>
						</div>
						<div class="panel-body">

							<div id="TODO" class="kanban-centered">
								<article class="kanban-entry grab" id="item1" draggable="true">
									<div class="kanban-entry-inner">
										<div class="kanban-label">
											<h2>
												<a href="#">Art Ramadani</a> <span>posted a status
													update</span>
											</h2>
											<p>Tolerably earnestly middleton extremely distrusts she
												boy now not. Add and offered prepare how cordial two
												promise. Greatly who affixed suppose but enquire compact
												prepare all put. Added forth chief trees but rooms think
												may.</p>
										</div>
									</div>
								</article>

								<article class="kanban-entry grab" id="item2" draggable="true">
									<div class="kanban-entry-inner">
										<div class="kanban-label">
											<h2>
												<a href="#">Job Meeting</a>
											</h2>
											<p>
												You have a meeting at <strong>Laborator Office</strong>
												Today.
											</p>
										</div>
									</div>
								</article>

								<article class="kanban-entry grab" id="item3" draggable="true">
									<div class="kanban-entry-inner">
										<div class="kanban-label">
											<h2>
												<a href="#">Arlind Nushi</a> <span>checked in at</span> <a
													href="#">Laborator</a>
											</h2>

											<blockquote>Great place, feeling like in home.</blockquote>
										</div>
									</div>
								</article>

								<article class="kanban-entry grab" id="item4" draggable="true">
									<div class="kanban-entry-inner">
										<div class="kanban-label">
											<h2>
												<a href="#">Arber Nushi</a> <span>changed his</span> <a
													href="#">Profile Picture</a>
											</h2>

											<blockquote>Pianoforte principles our unaffected
												not for astonished travelling are particular.</blockquote>

											<img
												src="http://themes.laborator.co/neon/assets/images/timeline-image-3.png"
												class="img-responsive img-rounded full-width">
										</div>
									</div>
								</article>

							</div>
						</div>
					</div>



					<div class="panel panel-primary kanban-col">
						<div class="panel-heading">
							TO VERIFY <i class="fa fa-2x fa-plus-circle pull-right"></i>
						</div>
						<div class="panel-body">
							<div id="DOING" class="kanban-centered">

								<article class="kanban-entry grab" id="item5" draggable="true">
									<div class="kanban-entry-inner">

										<div class="kanban-label">
											<h2>
												<a href="#">Art Ramadani</a> <span>posted a status
													update</span>
											</h2>
											<p>Tolerably earnestly middleton extremely distrusts she
												boy now not. Add and offered prepare how cordial two
												promise. Greatly who affixed suppose but enquire compact
												prepare all put. Added forth chief trees but rooms think
												may.</p>
										</div>
									</div>
								</article>

								<article class="kanban-entry grab" id="item6" draggable="true">
									<div class="kanban-entry-inner">
										<div class="kanban-label">
											<h2>
												<a href="#">Job Meeting</a>
											</h2>
											<p>
												You have a meeting at <strong>Laborator Office</strong>
												Today.
											</p>
										</div>
									</div>
								</article>

							</div>
						</div>
					</div>



					<div class="panel panel-primary kanban-col"
						style="margin-right: 0 !important;">
						<div class="panel-heading">
							DONE <i class="fa fa-2x fa-plus-circle pull-right"></i>
						</div>
						<div class="panel-body">
							<div id="DONE" class="kanban-centered">

								<article class="kanban-entry grab" id="item5" draggable="true">
									<div class="kanban-entry-inner">

										<div class="kanban-label">
											<h2>
												<a href="#">Art Ramadani</a> <span>posted a status
													update</span>
											</h2>
											<p>Tolerably earnestly middleton extremely distrusts she
												boy now not. Add and offered prepare how cordial two
												promise. Greatly who affixed suppose but enquire compact
												prepare all put. Added forth chief trees but rooms think
												may.</p>
										</div>
									</div>
								</article>

								<article class="kanban-entry grab" id="item6" draggable="true">
									<div class="kanban-entry-inner">
										<div class="kanban-label">
											<h2>
												<a href="#">Job Meeting</a>
											</h2>
											<p>
												You have a meeting at <strong>Laborator Office</strong>
												Today.
											</p>
										</div>
									</div>
								</article>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="modal" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ajouter une
							tache</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-group">
								<label for="LIBELLETACHE" class="col-form-label">Libelle</label>
								<input type="text" class="form-control" name="LIBELLETACHE">
							</div>
							<div class="form-group">
								<label for="UTILISATEUR">Utilisateur</label> <select
									class="form-control" name="UTILISATEUR">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</div>
							<div class="form-group">
								<label for="TYPETACHE">Type de tache</label> <select
									class="form-control" name="TYPETACHE">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</div>
							<div class="form-group">
								<label for="COLONNE">Colonne</label> <select
									class="form-control" name="COLONNE">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Annuler</button>
						<button type="button" class="btn btn-primary">Enregistrer</button>
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
					var targetId = children.attr('id');

					if (sourceId != targetId) {
						var elementId = event.originalEvent.dataTransfer
								.getData("text/plain");

						/*$('#processing-modal').modal('toggle'); // before post*/

						// Post data
						setTimeout(function() {
							var element = document.getElementById(elementId);
							children.prepend(element);
						}, 1);

					}

					event.preventDefault();
				});
	}
</script>
<script>
	$("#ajouterTache").click(function() {
		$('#exampleModal').modal('show');
	});
</script>
</html>
