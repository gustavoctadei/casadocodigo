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
    </head>
    <body>
        
        <form:form action="${ s:mvcUrl('gravarProduto').build() }" commandName="produto" method="post" enctype="multipart/form-data">
            <div>
                <label>Título</label>
                <form:input path="titulo" />
                <form:errors path="titulo" />
            </div>

            <div>
                <label>Descrição</label>
                <form:textarea rows="10" cols="20" path="descricao" />
                <form:errors path="descricao" />
            </div>

            <div>
                <label>Páginas</label>
                <form:input path="paginas" />
                <form:errors path="paginas" />
            </div>
            
            <div>
                <label>Data de Lançamento</label>
                <form:input path="dataLancamento" />
                <form:errors path="dataLancamento" />
            </div>

            <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
                <div>
                    <label>${tipoPreco}</label>
                    <form:input path="precos[${status.index}].valor" />
                    <form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}" />
                </div>
            </c:forEach>
            
            <div>
                <label>Sumário</label>
                <input name="sumario" type="file">
            </div>

            <button type="submit">Cadastrar</button>
        </form:form>

    </body>
</html>
