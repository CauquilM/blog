
package servlets;

import dao.DAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.ArticleBean;

/**
 *
 * @author Herbert Caffarel
 */
@WebServlet(urlPatterns = "/createArticle")
public class createArticle extends HttpServlet {

    /* Des constantes */
    private static final String VUE = "/WEB-INF/createArticle.jsp";

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        /* Affichage de la page de création d'un article */
        this.getServletContext()
                .getRequestDispatcher(VUE)
                .forward(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Appeler le vérificateur du formulaire
        // qui va vérifier les valeurs et créer un bean si ells sont valides
        // et retourner ce bean.
        // Si les valeurs sont fausses, le bean retourné sera null
        ArticleBean obj = new ArticleBean();
        obj.setTitle(request.getParameter("title"));
        obj.setContent(request.getParameter("content"));
        // Choix arbitraire puisque je n'ai poas géré les sessions
        obj.setAuthor(2);
        DAOFactory.getArticleDao().persist(obj);
        // Redirection vers la page d'accueil
        response.sendRedirect(request.getServletContext().getContextPath() + "/");
    }

}
