package models;

/**
 * Classe définissant les obligations des beans pour ce logiciel.
 *
 * @author Herbert Caffarel
 */
public abstract class Bean implements Identifiable {
    // Notons qu'on aurait pu se passer de l'interface identifiable et définir
    // directement Bean comme l'interface contenant getId() et setId().
    // Mais une interface se finit en principe par "able" et "Beanable" n'est
    // pas joli.
}
