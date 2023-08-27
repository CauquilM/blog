package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Bean;

/**
 * Classe abstraite formalisant le contenu d'une classe d'accès à une table
 * connue. Fournit le CRUD sur cette table, ainsi que le count et la liste des
 * lignes de la table.
 *
 * @author Herbert Caffarel
 */
public abstract class DAO<T extends Bean> {

    protected Connection connection = SQLiteConnection.getConnection();
    protected String table;

    public DAO(String table) {
        this.table = table;
    }

    /**
     * Sauvegarder les données d'un bean dans la table correspondante.
     *
     * @param obj Le bean à persister
     */
    protected abstract void create(T obj);

    /**
     * Mettre à jour un bean dans la table correspondante.
     *
     * @param obj Le bean à persister
     */
    protected abstract void update(T obj);

    /**
     * Fabriquer un bean à partir des données d'une ligne de la table
     * correspondante.
     *
     * @param rs Les données pour hydrater le bean
     * @return Le bean créé
     */
    protected abstract T createBean(ResultSet rs);

    /**
     * Persister un bean dans la table correspondante. Crée la ligne si elle
     * n'existe pas, la met à jour sinon.
     *
     * @param obj L'objet à persister
     */
    public void persist(T obj) {
        if (obj.getId() == null) {
            create(obj);
        } else {
            update(obj);
        }
    }

    /**
     * Hydrate un bean avec les données d'une ligne de la table correspondante.
     *
     * @param id L'identifiant de la ligne de la table
     * @return Le bean hydraté des valeurs de la table
     */
    public T get(String email, String password) {
        T obj = null;
        String sql = "SELECT * FROM " + table + " WHERE email =? AND password =?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = createBean(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    /**
     * Supprime une ligne de la table.
     *
     * @param id L'identifiant de la ligne à supprimer
     */
    public void delete(int id) {
        String sql = "DELETE FROM " + table + " WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Supprime une ligne de la table.
     *
     * @param obj Le bean correspondant à supprimer dans la table.
     */
    public void delete(T obj) {
        delete(obj.getId());
    }

    /**
     * Fournit la liste des éléments de la table correspondante.
     *
     * @return Une liste de beans
     */
    public List<T> list() {
        List<T> list = new ArrayList<>();
        String sql = "SELECT * FROM " + table;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(createBean(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Fournit le nombre de lignes de la table correspondante.
     *
     * @return Le nombre d'entrées de la table
     */
    public int count() {
        int count = 0;
        String sql = "SELECT COUNT(*) AS count FROM " + table;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
