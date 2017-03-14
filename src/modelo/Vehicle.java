/*
 * Author Roger G. Coscojuela
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Roger G. Coscojuela
 */

@Entity
@Table(name = "M6UF2_VEHICLES")
@NamedQueries({
@NamedQuery(name="VehicleMatricula", query="SELECT v FROM Vehicle v WHERE v.matricula=:matricula"),
@NamedQuery(name="vehiclesXClient", query="SELECT v FROM Vehicle v WHERE v.propietari=:propietari")})
public class Vehicle implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "vehicleId")
    private Long id;
    
    
    @Column (name= "matricula",unique=true, length = 7,nullable=false)
    @IndexColumn(name="indexVehicle")
    private String matricula;
    
    @Column (name= "marca", nullable=false)
    private String marca;
    
    @Column (name= "anyMatriculacio", nullable=false)
    private int anyMatriculacio;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "propietari")
    private Client propietari;

    public Vehicle(Long id, String matricula, String marca, int anyMatriculacio, Client propietari) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.anyMatriculacio = anyMatriculacio;
        this.propietari = propietari;
    }
    
    public Vehicle(String matricula, String marca, int anyMatriculacio, Client propietari) {
        this.matricula = matricula;
        this.marca = marca;
        this.anyMatriculacio = anyMatriculacio;
        this.propietari = propietari;
    }
    
    public Vehicle(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnyMatriculacio() {
        return anyMatriculacio;
    }

    public void setAnyMatriculacio(int anyMatriculacio) {
        this.anyMatriculacio = anyMatriculacio;
    }

    public Client getPropietari() {
        return propietari;
    }

    public void setPropietari(Client propietari) {
        this.propietari = propietari;
    }
    
    
}
