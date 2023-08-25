package models;

/**
 *
 * @author Herbert Caffarel
 */
public class PersonneBean extends Bean {

    private int id_personne;
    private String name;

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id_personne;
    }

    @Override
    public String toString() {
        return "PersonneBean{" + "id_personne=" + id_personne + ", name=" + name + '}';
    }

}
