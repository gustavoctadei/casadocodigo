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
    </head>
    <body>
        
        <form:form action="${ s:mvcUrl('gravarProduto').build() }" commandName="produto" method="post">
            <div>
                <label>Título</label>
                <input type="text" name="titulo">
                <form:errors path="titulo" />
            </div>

            <div>
                <label>Descrição</label>
                <textarea rows="10" cols="20" name="descricao"></textarea>
                <form:errors path="descricao" />
            </div>

            <div>
                <label>Páginas</label>
                <input type="text" name="paginas">
                <form:errors path="paginas" />
            </div>

            <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
                <div>
                    <label>${tipoPreco}</label>
                    <input type="text" name="precos[${status.index}].valor">
                    <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}">
                </div>
            </c:forEach>

            <button type="submit">Cadastrar</button>
        </form:form>

    </body>
</html>
