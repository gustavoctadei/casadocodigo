<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Erro - Comportamento Inesperado">
    <section id="index-section" class="container middle">
        
        <h2>Erro Genérico acontecendo</h2>
        
        <!--
            Mensagem: ${exception.message}
            <c:forEach items="${exception.stackTrace}" var="stk">
                ${stk}
            </c:forEach>
        -->
        
    </section>
</tags:pageTemplate>

