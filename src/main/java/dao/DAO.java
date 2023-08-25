package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Bean;

/**
 *
 * @author Herbert Caffarel
 */
public abstract class DAO<T extends Bean> {

    Connection connection = SQLiteConnection.getConnection();
    String table;

    public DAO(String table) {
        this.table = table;
    }

    protected abstract T createBean(ResultSet rs);

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

    public abstract void create(T obj);

    public abstract void update(T obj);

    public abstract T get(int id);

    public abstract List<T> list();

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

    public void delete(T obj) {
        delete(obj.getId());
    }
}
