<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
<spring:url value="/resources/css/estilos.css" var="estilos" />
<link href="${estilos}" rel="stylesheet" />          
        <title>Spring(06a) - Form2</title>
    </head>
    <body>
        <div id="contenedor">
            <h2>Spring(06a) - Form2 <br /> (Anotac + Model Y View + Model + RequestMapping)</h2>
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Password</th>
                        <th>Id</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><c:out value="${nombre}" /></td>
                        <td><c:out value="${password}" /></td>
                        <td><c:out value="${id}" /></td>
                    </tr>
                </tbody>
            </table>
         </div>
    </body>
</html>
