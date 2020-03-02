<%-- 
    Document   : form
    Created on : 20/02/2020, 08:41:28
    Author     : Gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
    </head>
    <body>
        
        <h1>Lista de Produtos</h1>
        
        <table>
            <tr>
                <td>Título</td>
                <td>Descrição</td>
                <td>Páginas</td>
            </tr>
            
            <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td>${produto.titulo}</td>
                    <td>${produto.descricao}</td>
                    <td>${produto.paginas}</td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
