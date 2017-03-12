/*
 * Author Roger G. Coscojuela
 */

package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Roger G. Coscojuela
 */
@Entity
@Table(name = "M6UF2_POLISSES")
public class Polissa implements Serializable {

    public enum TipusPolissa {
		TOT_RISC, TERCERS
	}
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column (name = "idPolissa")
    private Long id;
    
    
    @Column (name= "numeroPolissa", length=10)
    private String numeroPolissa;
    
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "prenedor", nullable=false)
    @IndexColumn(name="indexPrenedor")
    private Client prenedor;
    
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "vehicle", nullable=false)
    private Vehicle vehicle;
    

    @Column (name= "dataInici", nullable=false)
    private Calendar dataInici;
    
    @Column (name= "dataFi", nullable=false)
    private Calendar dataFi;
    
    @Column (name= "tipusPolissa")
    private TipusPolissa tipus;

    @Column (name= "prima")
    private double prima;
   
   

    public Polissa(Long id, String numeroPolissa, Client prenedor, Vehicle vehicle, Calendar dataInici, Calendar dataFi, TipusPolissa tipus, double prima) {
        this.id = id;
        this.numeroPolissa = numeroPolissa;
        this.prenedor = prenedor;
        this.vehicle = vehicle;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.tipus = tipus;
        this.prima = prima;
    }
    
    public Polissa(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroPolissa() {
        return numeroPolissa;
    }

    public void setNumeroPolissa(String numeroPolissa) {
        this.numeroPolissa = numeroPolissa;
    }

    public Client getPrenedor() {
        return prenedor;
    }

    public void setPrenedor(Client prenedor) {
        this.prenedor = prenedor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Calendar getDataInici() {
        return dataInici;
    }

    public void setDataInici(Calendar dataInici) {
        this.dataInici = dataInici;
    }

    public Calendar getDataFi() {
        return dataFi;
    }

    public void setDataFi(Calendar dataFi) {
        this.dataFi = dataFi;
    }

    public TipusPolissa getTipus() {
        return tipus;
    }

    public void setTipus(TipusPolissa tipus) {
        this.tipus = tipus;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    } 
}
