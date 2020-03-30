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

        <c:url value="/resources/css" var="cssPath" />
        <link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
        <link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css">
        
<!--        <style type="text/css">
            body {
                padding-top: 60px;
            }
        </style>-->
        
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${s:mvcUrl('index').build()}">Casa do Código</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="${s:mvcUrl('listarProdutos').build()}">Lista de Produtos</a></li>
                        <li><a href="${s:mvcUrl('formProdutos').build()}">Cadastro de Produtos</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div>
        </nav>

        <div class="container">

            <h1>Lista de Produtos</h1>

            <div>${sucesso}</div>
            <div>${falha}</div>

            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th>Título</th>
                    <th>Descrição</th>
                    <th>Páginas</th>
                </tr>

                <c:forEach items="${produtos}" var="produto">
                    <tr>
                        <td> <a href="${ s:mvcUrl('detalheProduto').arg(0, produto.id).build() }">${produto.titulo}</a> </td>
                        <td>${produto.descricao}</td>
                        <td>${produto.paginas}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>

    </body>
</html>
