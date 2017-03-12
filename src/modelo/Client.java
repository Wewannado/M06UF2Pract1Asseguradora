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
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Roger G. Coscojuela
 */
@Entity
@NamedQuery(name="ClientNif", query="SELECT c FROM Client c WHERE c.nif=:nif")
@Table(name = "M6UF2_CLIENTS")
public class Client implements Serializable{

    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column (name = "clientId")
    private Long id;
    
    @Column (name= "nif", unique=true, nullable=false)
    private String nif;
    
    @Column (name= "nomClient")
    private String nom;
    
    @Embedded
    private Adreca adreca = new Adreca();

    public Client(String nif, String nom) {
        this.nif = nif;
        this.nom = nom;
    }
    
    public Client() {
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adreca getAdreca() {
        return adreca;
    }

    public void setAdreca(Adreca adreca) {
        this.adreca = adreca;
    }
    
    
    
    
    
}
