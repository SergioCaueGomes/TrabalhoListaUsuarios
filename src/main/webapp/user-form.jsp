<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: green">
			<div>
				<a href="#" class="navbar-brand">Adicionar Usuarios</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%= request.getContextPath() %>/list" class="nav-link">Usuarios</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
				<form action="update" method="post">
				</c:if>
				<c:if test="${user = null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${user == null}">Edit</c:if>
						<c:if test="${user != null}">Adicionar Usuario</c:if>
					</h2>
				</caption>
				
				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id }' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Nome</label><input type="text" value="<c:out value='${user.nome}'/>" class="form-control" name="nome" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Email</label><input type="text" value="<c:out value='${user.email}'/>" class="form-control" name="email">
				</fieldset>
				<fieldset class="form-group">
					<label>Pais</label><input type="text" value="<c:out value='${user.pais}'/>" class="form-control" name="pais">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>