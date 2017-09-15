<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav
	class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="TiendaOnline">Tienda online</a>

	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="TiendaOnline">Inicio
					<span class="sr-only">(current)</span></a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="http://example.com"
				id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">Categorias</a>
				<div class="dropdown-menu" aria-labelledby="dropdown01">
					<c:forEach items="${categorias}" var="categoria">
						<a class="dropdown-item" href="TiendaOnline?action=categoria&id=${categoria.id}">${categoria}</a>
					</c:forEach>
				</div></li>
				<li class="nav-item"><a class="nav-link" href="TiendaOnline?action=top">Top ventas</a></li>
				<li class="nav-item"><a class="nav-link" href="TiendaOnline?action=recomendados">Recomendados</a></li>
		</ul>
		<form class="form-inline" method="get" action="TiendaOnline">
		    <input class="form-control mr-sm-2" type="text" placeholder="Buscar juego" name="nombre" value="">
		    <input type="hidden" name="action" value="buscarNombre">
		    <input class="invisible" type="submit">
		</form>
		<a href="TiendaOnline?action=carrito">
		<span class="navbar-text icono ">
			<c:if test = "${items ne 0}">
         		<span class="badge badge-pill badge-info">${items}</span>
      		</c:if>
		 <i
			class="fa fa-shopping-cart" aria-hidden="true"></i>
		</span>
		</a>
	</div>
</nav>