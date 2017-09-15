<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<spring:url value="/resources/css/estilos.css" var="estilos" />
<link href="${estilos}" rel="stylesheet" />
<title>Spring (06b) - FormBasico_Model_v2 - Form2</title>
</head>
<body>
	<div id="contenedor">
		<h2>
			Spring06b-FormBasico_Model_v2 Form2 <br /> (Anotac + Model&View + Model
			+ RequestMapping)
		</h2>
		<table>
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Autor</th>
					<th>Sinopsis</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${libro.nombre}" /></td>
					<td><c:out value="${libro.autor}" /></td>
					<td><c:out value="${libro.sinopsis}" /></td>
				</tr>
			</tbody>
		</table>
</body>
</html>
