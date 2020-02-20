<%-- 
    Document   : form
    Created on : 20/02/2020, 08:41:28
    Author     : Gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
    </head>
    <body>
        
        <form action="/casadocodigo/produtos" method="post">
            <div>
                <label>Título</label>
                <input type="text" name="titulo">
            </div>
            <div>
                <label>Descrição</label>
                <textarea rows="10" cols="20" name="descricao"></textarea>
            </div>
            <div>
                <label>Páginas</label>
                <input type="text" name="paginas">
            </div>
            <button type="submit">Cadastrar</button>
        </form>
        
    </body>
</html>
