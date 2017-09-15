<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<jsp:include page="template/css.jsp">
		<jsp:param name="titulo" value="Detalle" />
	</jsp:include>
</head>

<body>
	<jsp:include page="template/navbar.jsp"></jsp:include>
	<div class="container">
		<div class="card padre-icono-recomendado">
			<c:if test = "${juego.recomendado}">
        	<i class="fa fa-star fa-2x text-primary icono-recomendado" aria-hidden="true"></i>
     		</c:if>
			<div class="row">
				<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">
					<img class="card-img-top img-fluid" src="${juego.rutaImg}"
						alt="Card image cap">
				</div>
				<div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">
					<div class="card-block">
						<h4 class="card-title">Detalles del juego</h4>
						<div class="card-text">
							<dl class="row">
								<dt class="col-sm-3">Título</dt>
								<dd class="col-sm-9">${juego.titulo }</dd>
								<dt class="col-sm-3">Descripción</dt>
								<dd class="col-sm-9">${juego.descripcion}</dd>
								<dt class="col-sm-3">Categoría</dt>
								<dd class="col-sm-9">${juego.categoria}</dd>
								<dt class="col-sm-3">Jugadores</dt>
								<dd class="col-sm-9">${juego.minNumJug}
									<c:if test = "${juego.minNumJug ne juego.maxNumJug}">
         								- ${juego.maxNumJug}
      								</c:if>
								</dd>
								<dt class="col-sm-3">Precio</dt>
								<dd class="col-sm-9">
									<fmt:formatNumber type="currency" currencySymbol="€"
										value="${juego.precio}"/>
								</dd>
							</dl>
						</div>
						<form>
							<input type="hidden" name="action" value="addcart"> <input
								type="hidden" name="id" value="${juego.id}">
							<button type="submit" class="btn btn-success">Añadir al carrito</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="template/javascript.jsp"></jsp:include>
</body>
</html>
