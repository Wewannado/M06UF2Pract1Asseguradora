/*
 * Author Roger G. Coscojuela
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Roger G. Coscojuela
 */
@Entity
@Table(name = "M6UF2_USUARIS")
@NamedQueries({
@NamedQuery(name="userPerNom", query="SELECT u FROM Usuari u WHERE u.nom=:nom")})
public class Usuari implements Serializable {

    @Id
    @Column(name = "nom", nullable = false, length = 30)
    private String nom;

    @Column(name = "pass", length = 30)
    private String password;

    public Usuari(String nom, String password) {
        
        this.nom = nom;
        this.password = password;
    }

    public Usuari() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
