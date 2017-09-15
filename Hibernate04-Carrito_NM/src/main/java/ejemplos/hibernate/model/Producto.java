package ejemplos.hibernate.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ejemplos.hibernate.util.Simulaciones;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "relacion_nm_producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "id_producto", unique = true, nullable = false)
    private Integer idProducto;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "productoSet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Carrito> carritoSet;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String desc) {
        this.idProducto = idProducto;
        this.descripcion = desc;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Carrito> getCarritoSet() {
        return carritoSet;
    }

    public void setCarritoSet(Set<Carrito> carritoSet) {
        this.carritoSet = carritoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", desc=" + descripcion + ", carritoSet=" + carritoSet + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        //He decidido esto.. puedo decidir otra cosa.. soy un alma libre
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    public void productoPrueba(){
        this.nombre = "Producto_"+ Simulaciones.numeroAleatorio(3000);
        //Creo un texto aleatorio de entre 15-30 letras
        this.descripcion = Simulaciones.textoAleatorio(Simulaciones.randBetween(15, 30));
    }

    
}