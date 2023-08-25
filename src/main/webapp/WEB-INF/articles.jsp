<%-- 
    Document   : users
    Created on : 25 août 2023, 15:56:27
    Author     : Herbert Caffarel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Articles</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/assets/css/form.css"/>" />
    </head>
    <body>
        <h1>Nos articles</h1>
        <c:forEach items="${list}" var="article">
            <article>
                <h2>${article.title} (id : ${article.id})</h2>
                <p>Écrit par ${article.author} le ${article.created}</p>
                <div>${article.content}</div>
            </article>
        </c:forEach>
    </body>
</html>
