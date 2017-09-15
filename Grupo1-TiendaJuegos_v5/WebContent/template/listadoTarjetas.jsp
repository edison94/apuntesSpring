<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty title}">
	<h1>${title}</h1>
</c:if>

<c:choose>
	<c:when test="${empty juegos}">
		<section class="jumbotron text-center">
			<div class="container">
				<h1 class="jumbotron-heading">No hay juegos</h1>
				<p class="lead text-muted">El listado de juegos no pudo ser
					mostrado porque no se encontraron coincidencias</p>
			</div>
		</section>
	</c:when>
	<c:otherwise>
		<div class="row">
			<c:forEach items="${juegos}" var="juego" varStatus="loopCounter">
				<div class=" card-group mb-4 col-12 col-sm-12 col-md-6 col-lg-4 col-xl-4">
					<div class="card text-center padre-icono-recomendado">
						<a href="TiendaOnline?action=show&id=${juego.id}">
						<c:if test = "${juego.recomendado}">
         					<i class="fa fa-star fa-2x text-primary icono-recomendado" aria-hidden="true"></i>
      					</c:if>
      					<c:if test = "${isOrdenada}">
							<div class="card-header ">
    							<h3>#${loopCounter.count}</h3>
  							</div>
      					</c:if>
						<img
							class="card-img-top img-fluid" src="${juego.rutaImg}"
							alt="Portada del libro ${juego.titulo}">
						<div class="card-block">
							<h4 class="card-title">${juego.titulo}</h4>
							<p class="card-text">${juego.descripcion}</p>
						</div>
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:otherwise>
</c:choose>