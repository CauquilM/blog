<%-- 
    Document   : inscription
    Created on : 22 août 2023, 22:35:14
    Author     : Herbert Caffarel
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'article</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/assets/css/form.css"/>" />
    </head>
    <body>
        <form method="post" action="<c:url value="/createArticle"/>">
            <fieldset>
                <legend>Créer un article</legend>
                <p>Vous pouvez partager avec les autres.</p>
                <label for="title">titre <span class="mandatory">*</span></label>
                <input type="text" id="title" name="title" value="" size="20" maxlength="60" />
                <br />
                <label for="content">Contenu <span class="mandatory">*</span></label>
                <textarea type="text" id="content" name="content" value="" rows="20" cols="50"></textarea> <br>
                <input type="submit" value="Partager" class="noLabel" />
                <p>Les champs marqués d'un <span class="mandatory">*</span> sont obligatoires.</p>
            </fieldset>
        </form>
    </body>
</html>