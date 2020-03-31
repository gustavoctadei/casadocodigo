<%-- 
    Document   : form
    Created on : 20/02/2020, 08:41:28
    Author     : Gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>

        <c:url value="/resources/css" var="cssPath" />
        <link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
        <link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css">

        <style type="text/css">
            body {
                padding-bottom: 60px;
            }
        </style>

    </head>
    <body>

        <div class="container">

            <h1>Login da Casa do Código</h1>

            <form:form servletRelativeAction="/login" method="post">
                <div class="form-group">
                    <label>E-mail</label>
                    <input name="username" type="text" class="form-control" />
                </div>
                
                <div class="form-group">
                    <label>Senha</label>
                    <input name="password" type="password" class="form-control" />
                </div>

                <button type="submit" class="btn btn-primary">Login</button>
            </form:form>

        </div>

    </body>
</html>
