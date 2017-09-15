package ejemplos.hibernate.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import ejemplos.hibernate.util.Simulaciones;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "relacion_1n_telefono")
public class Telefonos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTelefono;

    private String tipo;
    private int codigoPais;
    private String numero;

    public Telefonos() {
    }

    public Telefonos(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public Telefonos(Integer idTelefono, String tipo, int codigoPais, String numero) {
        this.idTelefono = idTelefono;
        this.tipo = tipo;
        this.codigoPais = codigoPais;
        this.numero = numero;
    }

    public Integer getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefono != null ? idTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefonos other = (Telefonos) obj;
        if (this.codigoPais != other.codigoPais) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "Telefonos{" + "idTelefono=" + idTelefono + ", tipo=" + tipo + ", codigoPais=" + codigoPais + ", numero=" + numero + '}';
    }

    public Telefonos simularTelefono() {
        this.codigoPais = Simulaciones.codigoTelefono();
        this.tipo = Simulaciones.tipoTelefono();
        this.numero = Simulaciones.numTelefono();
        return this;
    }

}
