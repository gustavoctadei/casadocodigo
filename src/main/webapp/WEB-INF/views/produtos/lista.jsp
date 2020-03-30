<%-- 
    Document   : form
    Created on : 20/02/2020, 08:41:28
    Author     : Gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
        
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<!--        <script src="resources/js/bootstrap.min.js"></script>-->
    </head>
    <body>
        
        <h1>Lista de Produtos</h1>
        
        <div>${sucesso}</div>
        <div>${falha}</div>
        
        <table>
            <tr>
                <td>Título</td>
                <td>Descrição</td>
                <td>Páginas</td>
            </tr>
            
            <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td> <a href="${ s:mvcUrl('detalheProduto').arg(0, produto.id).build() }">${produto.titulo}</a> </td>
                    <td>${produto.descricao}</td>
                    <td>${produto.paginas}</td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
