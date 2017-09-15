<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

    <head>
        <meta charset="UTF-8">
        <title>Spring08-FormValidation-Registro</title>
        <!-- 
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
        -->
        <spring:url value="static/css/bootstrap.css" var="bootstrap"/>
        <link href="${bootstrap}" rel="stylesheet" />
        <spring:url value="static/css/custom.css" var="custom"/>
        <link href="${custom}" rel="stylesheet" />        
    </head>

    <body>
		<!-- Para ver como manejar formularios con bootstrap echa un vistazo aqui -->
		<!-- http://www.w3schools.com/bootstrap/bootstrap_forms.asp -->
        <div class="form-container">

            <h2>Spring08-FormValidation-Registro</h2>

            <form:form method="POST" modelAttribute="student" class="form-horizontal">

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-label" for="firstName">Nombre (*)</label>
                        <div class="col-md-7">
                            <form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="firstName" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-label" for="lastName">Apellido (*)</label>
                        <div class="col-md-7">
                            <form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="lastName" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-label" for="sex">Sexo (*)</label>
                        <div class="col-md-7" class="form-control input-sm">
                            <form:radiobutton path="sex" value="M" />Hombre 
                            <form:radiobutton path="sex" value="F" />Mujer
                            <div class="has-error">
                                <form:errors path="sex" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-label" for="dob">Fecha nacimiento (dd/mm/yyyy) (*)</label>
                        <div class="col-md-7">
                            <form:input type="text" path="dob" id="dob" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="dob" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-label" for="email">Email (*)</label>
                        <div class="col-md-7">
                            <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="email" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-label" for="section">Tipo de estudios (*)</label>
                        <div class="col-md-7" class="form-control input-sm">
                            <form:radiobuttons path="section" items="${sections}" />
                            <div class="has-error">
                                <form:errors path="section" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-label" for="country">Pais (*)</label>
                        <div class="col-md-7">
                            <form:select path="country" id="country" class="form-control input-sm">
                                <form:option value="">Select Country</form:option>
                                <form:options items="${countries}" />
                            </form:select>
                            <div class="has-error">
                                <form:errors path="country" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-label" for="firstAttempt">¿Novato?¿Yogurín?</label>
                        <div class="col-md-1">
                            <form:checkbox path="firstAttempt" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="firstAttempt" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-label" for="subjects">Cursos (*)</label>
                        <div class="col-md-7">
                            <form:select path="subjects" items="${subjects}" multiple="true" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="subjects" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="Registrar" class="btn btn-primary btn-sm">
                    </div>
                </div>
            </form:form>
        </div>
    </body>
</html>