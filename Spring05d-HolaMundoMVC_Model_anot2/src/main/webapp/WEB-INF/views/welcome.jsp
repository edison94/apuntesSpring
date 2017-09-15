<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>

<spring:url value="/resources/css/estilos.css" var="estilos" />
<link href="${estilos}" rel="stylesheet" />

<meta charset="UTF-8">

<title>Spring05d-HolaMundoMVC_Model_AnotacionesII</title>
</head>
<body>
	<div id="contenedor">
		<h2>Spring(05d) - HolaMundoMVC_Model_AnotacionesII</h2>
		<p>Bienvenida: ${greeting}</p>
		<p>
			Hoy es día
			<fmt:formatDate pattern="d 'de' MMMM 'de' yyyy" value="${fecha}" />
		</p>
	</div>
</body>
</html>