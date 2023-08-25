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
        <title>Utilisateurs enregistrés</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/assets/css/form.css"/>" />
    </head>
    <body>
        <h1>Utilisateurs enregistrés</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Courriel</th>
                <th>Mot de passe</th>
                <th>Pseudo</th>
            </tr>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${user.name}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
