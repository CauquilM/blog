/*
 */
package filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Force toutes les communications entrantes en UTF-8.
 *
 * @author Herbert Caffarel
 */
@WebFilter(filterName = "FormEncoding", urlPatterns = {"/*"})
public class FormEncoding implements Filter {

    /* Le travail en entrée */
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
    }

    /* Le travail en sortie */
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
    }

    /**
     * Le travail effectué avant de passer la main au filtre suivant de la
     * chaine.
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        // Le travail à faire en entrée
        doBeforeProcessing(request, response);

        // Le passage au filtre suivant
        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }

        // Le travail à faire en sortie
        doAfterProcessing(request, response);
    }

}
