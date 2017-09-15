<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
<spring:url value="/resources/css/estilos.css" var="estilos" />
<link href="${estilos}" rel="stylesheet" />           
        <title>Spring(06a) - Formulario 1</title>
    </head>
    <body>

        <div id="contenedor">
            <h2>Spring(06a) - Form1 <br />(Anotac + Model Y View + Model + RequestMapping)</h2>
            <!-- IMPORTANTE: Puedo usar   modelAttribute="cliente"   o     commandName="cliente" -->
            <!-- Vale cualqueira de los dos y especifica el objeto donde iran los datos que se recojan  -->
            <!-- Previamente he pasado por ClienteController para recoger un cliente acio -->
            <form:form method="post" commandName="cliente" action="addCliente.htm">
                <table>
                    <tr>
                        <td><form:label path="nombre">Nombre</form:label></td>
                        <td><form:input path="nombre" /></td>
                    </tr>
                    <tr>
                        <td><form:label path="id">Nombre Usuario</form:label></td>
                        <td><form:input path="id" /></td>
                    </tr>
                    <tr>
                        <td><form:label path="password">Contraseña</form:label></td>
                        <td><form:input path="password" /></td>
                    </tr>                    
                </table>
                <br />
                <p><input type="submit" value="Dar de alta" /></p>
            </form:form>
        </div>
    </body>
</html>
