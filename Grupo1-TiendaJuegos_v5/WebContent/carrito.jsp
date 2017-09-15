<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="es">
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
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 70%"></th>
					<th style="width: 10%">Precio</th>
					<th style="width: 8%">Cantidad</th>
					<th style="width: 12%" class="text-center">Subtotal</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${carrito.items}" var="item">
					<tr>
						<td data-th="Producto">
							<div class="row">
								<div class="col-sm-6 hidden-xs">
									<img src="${item.juego.rutaImg}" alt="foto juego"
										class="img-fluid" />
								</div>
								<div class="col-sm-6">
									<h4 class="nomargin">${item.juego.titulo}</h4>
									<p>${item.juego.descripcion}</p>
								</div>
							</div>
						</td>
						<td data-th="Precio"><fmt:formatNumber type="currency" currencySymbol="€" 
									value="${item.juego.precio}"/></td>
						<td data-th="Cantidad">${item.cantidad}</td>
						<td data-th="Subtotal" ><fmt:formatNumber type="currency" currencySymbol="€" 
									value="${item.subtotal}"/></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td><a href="TiendaOnline" class="btn btn-warning"><i
							class="fa fa-angle-left"></i> Continuar Comprando</a></td>
					<td class="hidden-xs"></td>
					<td class="hidden-xs text-center">
						<strong>
							Total <fmt:formatNumber type="currency" currencySymbol="€" 
									value="${carrito.total}"/>
						</strong>
					</td>
					<td><a href="TiendaOnline?action=comprado" class="btn btn-success btn-block">Comprar
							<i class="fa fa-angle-right"></i>
					</a></td>
				</tr>
			</tfoot>
		</table>
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
	<jsp:include page="template/javascript.jsp"></jsp:include>
</body>
</html>