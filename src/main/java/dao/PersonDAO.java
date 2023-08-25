package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.PersonBean;

/**
 * DAO sur la table personnes. Fournit le CRUD ainsi que le count et la liste
 * des personnes.
 *
 * @author Herbert Caffarel
 */
public class PersonDAO extends DAO<PersonBean> {

    public PersonDAO() {
        super("person");
    }

    @Override
    protected PersonBean createBean(ResultSet rs) {
        PersonBean obj = new PersonBean();
        try {
            obj.setId(rs.getInt("id_person"));
            obj.setName(rs.getString("name"));
            obj.setEmail(rs.getString("email"));
            obj.setPassword(rs.getString("password"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    protected void create(PersonBean obj) {
        String sql = "INSERT INTO " + table + " (email, password, name) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getEmail());
            pstmt.setString(2, obj.getPassword());
            pstmt.setString(3, obj.getName());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                obj.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void update(PersonBean obj) {
        String sql = "UPDATE " + table + " SET email=?, password=?, name=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, obj.getEmail());
            pstmt.setString(2, obj.getPassword());
            pstmt.setString(3, obj.getName());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
