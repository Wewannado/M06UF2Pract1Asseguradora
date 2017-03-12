/*
 * Author Roger G. Coscojuela
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

/**
 *
 * @author Roger G. Coscojuela
 */
@Embeddable
@Table(name = "M6UF2_ADRECES")
public class Adreca implements Serializable {

    @Column(length = 50, nullable = false)
    private String carrer;

    @Column(nullable = false)
    private int numero;

    @Column(length = 50, nullable = false)
    private String poblacio;

    public Adreca(String carrer, int numero, String poblacio) {
        this.carrer = carrer;
        this.numero = numero;
        this.poblacio = poblacio;
    }

    public Adreca() {
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Adreca)) {
            return false;
        }
        Adreca other = (Adreca) o;

        return true;
    }

    @Override
    public String toString() {
        return "Adreca{" + "carrer=" + carrer + ", numero=" + numero + ", poblacio=" + poblacio + '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}
