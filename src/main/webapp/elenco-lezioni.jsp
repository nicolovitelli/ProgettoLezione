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
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<p>Progetto Lezione</p>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/elenco"
					class="nav-link">Lezioni</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">Lista Lezioni</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/nuovaLezione"
					class="btn btn-success">Aggiungi nuova Lezione</a>
			</div>
			<br/>
			<h2>Cerca per Argomento</h2>
			<form action="cercaPerArgomento" method="get">
				<input type="text" name="argomento" class="form-control" size="25"
					value="<c:out value='${lezione.argomento}' />"
					placeholder="Inserisci argomento" /><br />
				<button type="submit" class="btn btn-success">Cerca</button>
			</form>
			<br/>
			<h2>Cerca per Data</h2>
			<form action="cercaPerData" method="get">
				<input type="date" name="data" class="form-control" size="25"
					value="<c:out value='${lezione.data}' />" /><br />
				<button type="submit" class="btn btn-success">Cerca</button>
			</form>
			<br/>
			<table class="table table-striped table-bordered" id="elencoLezioni">
				<thead>
					<tr>
						<th onclick="sortTable(0)" style="cursor: pointer;">ID</th>
						<th onclick="sortTable(1)" style="cursor: pointer;">Data</th>
						<th onclick="sortTable(2)" style="cursor: pointer;">Argomento</th>
						<th onclick="sortTable(3)" style="cursor: pointer;">Descrizione</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="lezione" items="${lezioni}">
						<tr>
							<td><c:out value="${lezione.id}" /></td>
							<td><c:out value="${lezione.data}" /></td>
							<td><c:out value="${lezione.argomento}" /></td>
							<td><c:out value="${lezione.descrizione}" /></td>
							<td><a
								href="modificaLezione?id=<c:out value='${lezione.id}' />">Modifica</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="eliminaLezione?id=<c:out value='${lezione.id}' />">Elimina</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<script>
				function sortTable(n) {
					var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
					table = document.getElementById("elencoLezioni");
					switching = true;
					dir = "asc";
					while (switching) {
						switching = false;
						rows = table.rows;
						for (i = 1; i < (rows.length - 1); i++) {
							shouldSwitch = false;
							x = rows[i].getElementsByTagName("TD")[n];
							y = rows[i + 1].getElementsByTagName("TD")[n];
							if (dir == "asc") {
								if (x.innerHTML.toLowerCase() > y.innerHTML
										.toLowerCase()) {
									shouldSwitch = true;
									break;
								}
							} else if (dir == "desc") {
								if (x.innerHTML.toLowerCase() < y.innerHTML
										.toLowerCase()) {
									shouldSwitch = true;
									break;
								}
							}
						}
						if (shouldSwitch) {
							rows[i].parentNode.insertBefore(rows[i + 1],
									rows[i]);
							switching = true;
							switchcount++;
						} else {
							if (switchcount == 0 && dir == "asc") {
								dir = "desc";
								switching = true;
							}
						}
					}
				}
			</script>
		</div>
	</div>

</body>
</html>