<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Spring (07b) - Alta Usuario (Form Partido + Navegacion)</title>
        <meta charset="UTF-8">
        <link href="css/estilos.css" rel="stylesheet" type="text/css" />        
    </head>

    <body>

        <div id="contenedor">
            <h2>Paso 1 - Indicar usuario</h2>

            <form:form method="POST" commandName="command">
                <!-- aqui apareceran los errores globales -->
                <!-- se convertirá en un DIV -->
                <form:errors path="*" cssClass="destacado" element="div"/>
                <table>
                    <tr>
                        <td>Nombre Usuario: </td>
                        <td><form:input path="userName" /></td>
                        <!-- aqui aapreceran los errores -->
                        <td><form:errors path="userName" cssClass="destacado" /></td>
                    </tr>
                    <tr>

                    <tr>
                        <td colspan="3">
                            <!--
 With AbstractWizardFormController, the page sequence is determined by the ?name? of the submit button:

 _finish: Finish the wizard form.
 _cancel: Cancel the wizard form.
 _targetx: Move to the target page, where x is the zero-based page index. e.g _target0, _target1 and etc.
                            -->
                            <input type="submit" value="Ir al paso 2 >>" name="_target1" />
                            <input type="submit" value="Cancel" name="_cancel" />
                        </td>
                    </tr>

                </table>
            </form:form>
        </div>

    </body>
</html>