package dao;

/**
 *
 * @author Herbert Caffarel
 */
public final class DAOFactory {

    private static PersonneDAO personneDao;

    private DAOFactory() {
    }

    public static PersonneDAO getPersonneDao() {
        if (personneDao == null) {
            personneDao = new PersonneDAO();
        }
        return personneDao;
    }
}
