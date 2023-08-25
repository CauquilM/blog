package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton de connexion à la base de données SQLite.
 *
 * @author Herbert Caffarel
 */
public final class SQLiteConnection {

    private static Connection connection = null;

    private SQLiteConnection() {
    }

    /**
     * Fournit le singleton de connexion à l abase de données ou crée la base de
     * données si elle n'existe pas.
     *
     * @return Une connexion à la base de données
     */
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
            } catch (IOException | ClassNotFoundException | SQLException ex) {
                Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

}
