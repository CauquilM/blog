package dao;

/**
 * Fabrique de classe DAO sur le modèle des singletons.
 *
 * @author Herbert Caffarel
 */
public final class DAOFactory {

    private static PersonDAO personDao;
    private static ArticleDAO articleDao;

    private DAOFactory() {
    }

    /**
     *
     * @return Une DAO sur la table personne
     */
    public static PersonDAO getPersonDao() {
        if (personDao == null) {
            personDao = new PersonDAO();
        }
        return personDao;
    }

    /**
     *
     * @return Une DAO sur la table article
     */
    public static ArticleDAO getArticleDao() {
        if (articleDao == null) {
            articleDao = new ArticleDAO();
        }
        return articleDao;
    }
}
