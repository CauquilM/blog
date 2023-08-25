<%-- 
    Document   : index
    Created on : 22 août 2023, 22:38:26
    Author     : Herbert Caffarel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/assets/css/form.css"/>" />
    </head>
    <body>
        <h1>Exemple de fonctionnement</h1>
        <ul>
            <li>
                <a href="<c:url value="/createDatabase"/>">Créer la base de données</a> - 
                <span class="warning">Attention ! Supprime son contenu s'il existe !</span>
            </li>
            <li><a href="<c:url value="/logon"/>">Vers la page d'inscription</a></li>
            <li><a href="<c:url value="/createArticle"/>">Vers la page de création d'un article</a></li>
            <li><a href="<c:url value="/showUsers"/>">Voir les utilisateurs</a></li>
            <li><a href="<c:url value="/showArticles"/>">Voir les articles</a></li>
        </ul>
    </body>
</html>
