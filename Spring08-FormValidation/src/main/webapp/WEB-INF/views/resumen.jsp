<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring08-FormValidation-Confirmacion</title>
<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>
<body>
	<h2>Spring08-FormValidation-Confirmacion</h2>

	<h3>Datos que se han registrado</h3>
	<div class="success">
		<p>Nombre: ${student.firstName}</p>
		<p>Apellidos: ${student.lastName}</p>
		<p>Sexo: ${student.sex}</p>
		<p>Fecha Nacimiento: ${student.dob}</p>
		<p>Email: ${student.email}</p>
		<p>Tipo de estudios: ${student.section}</p>
		<p>Pais: ${student.country}</p>
		<p>¿Novato?: ${student.firstAttempt}</p>
		<p>Materias elegidas: ${student.subjects}</p>
	</div>
	<h3>Mensaje de confirmación</h3>
	<div class="success">
		${success} <br /> Te enviaremos un mensaje a la siguiente dirección de
		correo: ${student.email}.
	</div>
</body>
</html>