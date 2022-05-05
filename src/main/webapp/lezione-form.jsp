<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Progetto Lezione</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
				<p>Progetto Lezione</p>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%= request.getContextPath() %>/elenco" class="nav-link">Lezioni</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${lezione != null}">
					<form action="aggiornaLezione" method="post">
				</c:if>
				<c:if test="${lezione == null}">
					<form action="inserisciLezione" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${lezione != null}">
							Modifica Lezione
						</c:if>
					</h2>
				</caption>
				
				<c:if test="${lezione != null}">
					<input type="hidden" name="id" value="<c:out value='${lezione.id}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Data</label>
						<input type="text" value="<c:out value='${lezione.data}' />" class="form-control" name="data" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Argomento</label>
						<input type="text" value="<c:out value='${lezione.argomento}' />" class="form-control" name="argomento" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Descrizione</label>
						<input type="text" value="<c:out value='${lezione.descrizione}' />" class="form-control" name="descrizione">
				</fieldset>
				
				<button type="submit" class="btn btn-success">Salva</button>
				</form>
				
			</div>
		</div>
	</div>

</body>
</html>