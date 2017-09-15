<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<spring:url value="/resources/css/estilos.css" var="estilos" />
<link href="${estilos}" rel="stylesheet" />
<title>Spring06b-FormBasico_Model_v2 - Formulario 1</title>
</head>
<body>

	<div id="contenedor">
		<h2>
			Spring06b-FormBasico_Model_v2 - Form1 <br />(Anotac + Model&View +
			Model + RequestMapping)
		</h2>
		<!-- IMPORTANTE: Puedo usar   modelAttribute="cliente"   o     commandName="cliente" -->
		<!-- Aqui usamos  modelAttribute  porque estoy con model en el controller y uso alli modelAttribute  -->
		<form:form method="post" modelAttribute="libro"
			action="addLibro.htm">
			<table>
				<tr>
					<td><form:label path="nombre">Nombre Libro</form:label></td>
					<td><form:input path="nombre" /></td>
				</tr>
				<tr>
					<td><form:label path="autor">Nombre Autor</form:label></td>
					<td><form:input path="autor" /></td>
				</tr>
				<tr>
					<td><form:label path="sinopsis">Sinopsis</form:label></td>
					<td><form:input path="sinopsis" /></td>
				</tr>
			</table>
			<br />
			<p>
				<input type="submit" value="Dar de alta" />
			</p>
		</form:form>
	</div>
</body>
</html>
