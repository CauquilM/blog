package models;

/**
 * Bean pour la table person.
 *
 * @author Herbert Caffarel
 */
public class PersonBean extends Bean {

    private Integer id_personne;
    private String email;
    private String password;
    private String name;

    public Integer getId_personne() {
        return id_personne;
    }

    public void setId_personne(Integer id_personne) {
        this.id_personne = id_personne;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Integer getId() {
        return id_personne;
    }

    @Override
    public void setId(Integer id) {
        id_personne = id;
    }

    @Override
    public String toString() {
        return "PersonneBean{" + "id_personne=" + id_personne + ", email=" + email + ", password=" + password + ", name=" + name + '}';
    }

}
