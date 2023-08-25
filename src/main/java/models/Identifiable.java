
package models;

/**
 * Interfac définssant les besoin d'un objet identifiable.
 *
 * @author Herbert Caffarel
 */
public interface Identifiable {

    /**
     * Fournit l'identifiant unqiue de l'objet.
     *
     * @return L'identifiant unique de l'objet
     */
    Integer getId();

    /**
     * Définit l'identifiant unique de l'objet.
     *
     * @param id L'identifiant unique de l'objet
     */
    void setId(Integer id);
}
