package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ArticleBean;

/**
 * DAO sur la table article. Fournit le CRUD ainsi que le count et la liste des
 * articles.
 *
 * @author Herbert Caffarel
 */
public class ArticleDAO extends DAO<ArticleBean> {

    public ArticleDAO() {
        super("article");
    }

    @Override
    protected ArticleBean createBean(ResultSet rs) {
        ArticleBean obj = new ArticleBean();
        try {
            obj.setId(rs.getInt("id_article"));
            obj.setCreated(rs.getString("created"));
            obj.setTitle(rs.getString("title"));
            obj.setAuthor(rs.getInt("author"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    protected void create(ArticleBean obj) {
        String sql = "INSERT INTO " + table + " (title, content, author) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getTitle());
            pstmt.setString(2, obj.getContent());
            pstmt.setInt(3, obj.getAuthor());
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
    protected void update(ArticleBean obj) {
        String sql = "UPDATE " + table + " SET title=?, content=?, author=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, obj.getTitle());
            pstmt.setString(2, obj.getContent());
            pstmt.setInt(3, obj.getAuthor());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
