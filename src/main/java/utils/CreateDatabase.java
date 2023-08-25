package utils;

import dao.SQLiteConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Herbert Caffarel
 */
@WebServlet(urlPatterns = "/createDatabase")
public class CreateDatabase extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection connection = SQLiteConnection.getConnection();
        System.out.println("Essai de lecture du MPD SQLite");
        try (var sc = new Scanner(CreateDatabase.class.getResourceAsStream("/mpd_sqlite.sql"))) {
            sc.useDelimiter(";");
            System.out.println("Lecture du MPD SQLite");
            while (sc.hasNext()) {
                String sql = sc.next();
                System.out.println("Exécution de " + sql);
                connection.prepareStatement(sql).execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Fini !");
        response.sendRedirect(request.getServletContext().getContextPath() + "/");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new ServletException("doPost() not implemented in CreateDatabase!");
    }

}
