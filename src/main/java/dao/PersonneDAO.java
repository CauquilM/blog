package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.PersonneBean;

/**
 *
 * @author Herbert Caffarel
 */
public class PersonneDAO extends DAO<PersonneBean> {

    public PersonneDAO() {
        super("personne");
    }

    @Override
    public void create(PersonneBean obj) {
        String sql = "INSERT INTO " + table + " (name) VALUES (?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getName());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                obj.setId_personne(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(PersonneBean obj) {
        String sql = "UPDATE " + table + " SET name=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, obj.getName());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public PersonneBean get(int id) {
        PersonneBean obj = null;
        String sql = "SELECT * FROM " + table + " WHERE id_personne=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                obj = createBean(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public List<PersonneBean> list() {
        List<PersonneBean> list = new ArrayList<>();
        String sql = "SELECT * FROM " + table;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(createBean(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    protected PersonneBean createBean(ResultSet rs) {
        PersonneBean obj = new PersonneBean();
        try {
            obj.setId_personne(rs.getInt("id_personne"));
            obj.setName(rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

}
