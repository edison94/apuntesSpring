<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Grupo1">
<jsp:include page="template/css.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="template/navbar.jsp"></jsp:include>
	<div class="container">
		<p>${msgError}</p>
		<a href="TiendaOnline">Volver al HOME</a>
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
	<jsp:include page="template/javascript.jsp"></jsp:include>
</body>
</html>
