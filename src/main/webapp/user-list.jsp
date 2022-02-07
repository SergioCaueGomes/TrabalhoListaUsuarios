<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management Application</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" Style="background-color: green;">
			<div>
				<a href="#" class="navbar-brand"><h2>Raia Drogasil</h2> </a>
			</div>
			<ul class="navbar-nav" style="margin-top: -20px;">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link"><h4><nobr>Usuarios</nobr></h4></a></li>
			</ul>
		</nav>
	</header>
	<br>
	
	<div class="row">
	<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
		<div class="container">
			<h3 class="text-center">Lista de Usuários</h3>
				<hr>
			<div class="container te-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Adicionar Usuário</a>	
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Email</th>
						<th>Pais</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${listUser}">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.nome}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.pais}" /></td>
						<td><a href="edit?id=<c:out value='${user.id }' />">Editar</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		
		
		</div>
	</div>
</body>
</html>