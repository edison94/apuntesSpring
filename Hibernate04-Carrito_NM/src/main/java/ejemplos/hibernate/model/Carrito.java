package ejemplos.hibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ejemplos.hibernate.util.Simulaciones;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "relacion_nm_carrito")
public class Carrito implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carrito", unique = true, nullable = false)
	private Integer idCarrito;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	@JoinTable
	(name = "relacion_nm_carrito_producto", 
	joinColumns = { @JoinColumn(name = "id_carrito", referencedColumnName = "id_carrito") }, 
	inverseJoinColumns = { @JoinColumn(name = "id_producto", referencedColumnName = "id_producto") })
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Producto> productoSet;

	public Carrito() {
	}

	public Carrito(Integer idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Integer getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(Integer idCarrito) {
		this.idCarrito = idCarrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Set<Producto> getProductoSet() {
		return productoSet;
	}

	public void setProductoSet(Set<Producto> productoSet) {
		this.productoSet = productoSet;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idCarrito != null ? idCarrito.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Carrito)) {
			return false;
		}
		Carrito other = (Carrito) object;
		if ((this.idCarrito == null && other.idCarrito != null)
				|| (this.idCarrito != null && !this.idCarrito
						.equals(other.idCarrito))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Carrito{" + "idCarrito=" + idCarrito + ", nombre=" + nombre
				+ ", fechaCreacion=" + fechaCreacion + ", productoSet="
				+ productoSet + '}';
	}

	public void carritoPrueba() {
		this.nombre = "Carrito_" + Simulaciones.numeroAleatorio(3000);
		// Creo un texto aleatorio de 4 letras
		this.fechaCreacion = Simulaciones.fechaAleatoria();
	}

}
