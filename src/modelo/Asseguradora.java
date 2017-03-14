/*
 * Author Roger G. Coscojuela
 */

package modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Roger G. Coscojuela
 */
public class Asseguradora {

    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column (name = "idAsseguradora")
    private Long id;
    
    @Column (name= "nom", length=100, nullable=false, unique=true)
    private String nom;
    
    @Column (name= "cif", unique=true)
    private String cif;

    public Asseguradora(Long id, String nom, String cif) {
        this.id = id;
        this.nom = nom;
        this.cif = cif;
    }
    
    
    public Asseguradora(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }
    
    
}
