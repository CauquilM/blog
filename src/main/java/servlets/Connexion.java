/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PersonBean;

/**
 *
 * @author mathi
 */
@WebServlet(urlPatterns = "/connexion")
public class Connexion extends HttpServlet {

    /* Des constantes */
    private static final String VUE = "/WEB-INF/connexion.jsp";

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
        /* Affichage de la page d'inscription */
        this.getServletContext()
                .getRequestDispatcher(VUE)
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Appeler le vérificateur du formulaire
        // qui va vérifier les valeurs et créer un bean si ells sont valides
        // et retourner ce bean.
        // Si les valeurs sont fausses, le bean retourné sera null
        PersonBean obj = new PersonBean();
        obj.setEmail(request.getParameter("email"));
        obj.setPassword(request.getParameter("password"));
        System.err.print("obj: " + obj);
        DAOFactory.getPersonDao().persist(obj);
        // Redirection vers la page d'accueil
        response.sendRedirect(request.getServletContext().getContextPath() + "/");
    }

}
