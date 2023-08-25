package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Herbert Caffarel
 */
public final class SQLiteConnection {

    private static Connection connection = null;

    private SQLiteConnection() {
    }

    public static final Connection getConnection() {
        if (connection == null) {
            String url = "jdbc:sqlite:blog.db";
            try {
                System.out.println("Connexion à la DB");
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(url);
                if (connection == null) {
                    throw new IOException("DB inexistante");
                }
                try {
                    String sql = "CREATE TABLE personne(id_personne integer primary key autoincrement, name TEXT);";
                    connection.prepareStatement(sql).executeUpdate();
                } catch (SQLException ex) {
                    System.err.println("Table personne existe déjà");
                }
                try {
                    String sql = "CREATE TABLE article(id_article integer primary key autoincrement, content TEXT);";
                    connection.prepareStatement(sql).executeUpdate();
                } catch (SQLException ex) {
                    System.err.println("Table article existe déjà");
                }
            } catch (IOException | ClassNotFoundException | SQLException ex) {
                Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    {

    }
}
