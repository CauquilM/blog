<%-- 
    Document   : inscription
    Created on : 22 août 2023, 22:35:14
    Author     : Herbert Caffarel
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/assets/css/form.css"/>" />
    </head>
    <body>
        <form method="post" action="<c:url value="/connexion"/>">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>
                <label for="email">Adresse email <span class="mandatory">*</span></label>
                <input type="email" id="email" name="email" value="" size="20" maxlength="60" />
                <br />
                <label for="password">Mot de passe <span class="mandatory">*</span></label>
                <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
                <br />
                <input type="submit" value="Connexion" class="noLabel" />
                <p>Les champs marqués d'un <span class="mandatory">*</span> sont obligatoires.</p>
            </fieldset>
        </form>
    </body>
</html>