package ejemplos.hibernate.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
*
* @author Antonio
*/
@Entity
@Table(name = "relacion_11_direccion")
/*
Hay 4 valores
@NamedQueries: List of named queries
@NamedQuery: To map hibernate query to its logical name.
@NamedNativeQueries: List of named native queries
@NamedNativeQuery: To map raw/native JDBC query to its logical name.

@NamedQueries({ 
	@NamedQuery(
               name = "@HQL_GET_ALL_ADDRESS", 
               query = "from Direccion") })
@NamedNativeQueries({ 
	@NamedNativeQuery(
               name = "@SQL_GET_ALL_ADDRESS", 
               query = "select idDireccion, address, zipcode, city from Direccion") })

*/

@NamedQueries({
   @NamedQuery(name = "Direccion.findAll", query = "SELECT r FROM Direccion r"),
   @NamedQuery(name = "Direccion.findByIdDireccion", query = "SELECT r FROM Direccion r WHERE r.idDireccion = :idDireccion"),
   @NamedQuery(name = "Direccion.findByAddress", query = "SELECT r FROM Direccion r WHERE r.address = :address"),
   @NamedQuery(name = "Direccion.findByZipcode", query = "SELECT r FROM Direccion r WHERE r.zipcode = :zipcode"),
   @NamedQuery(name = "Direccion.findByCity", query = "SELECT r FROM Direccion r WHERE r.city = :city")})
public class Direccion implements Serializable {
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer idDireccion;
   private String address;
   private int zipcode;
   private String city;
   @JoinColumn(name = "persona_id", referencedColumnName = "id")
   @OneToOne
   private Persona personaId;

   public Direccion() {
   }

   public Direccion(Integer idDireccion) {
       this.idDireccion = idDireccion;
   }

   public Direccion(Integer idDireccion, String address, int zipcode, String city) {
       this.idDireccion = idDireccion;
       this.address = address;
       this.zipcode = zipcode;
       this.city = city;
   }
   
   public Direccion(String address, int zipcode, String city) {
       this.address = address;
       this.zipcode = zipcode;
       this.city = city;
   }    

   public Integer getIdDireccion() {
       return idDireccion;
   }

   public void setIdDireccion(Integer idDireccion) {
       this.idDireccion = idDireccion;
   }

   public String getAddress() {
       return address;
   }

   public void setAddress(String address) {
       this.address = address;
   }

   public int getZipcode() {
       return zipcode;
   }

   public void setZipcode(int zipcode) {
       this.zipcode = zipcode;
   }

   public String getCity() {
       return city;
   }

   public void setCity(String city) {
       this.city = city;
   }

   public Persona getPersonaId() {
       return personaId;
   }

   public void setPersonaId(Persona personaId) {
       this.personaId = personaId;
   }

   @Override
   public int hashCode() {
       int hash = 0;
       hash += (idDireccion != null ? idDireccion.hashCode() : 0);
       return hash;
   }

   @Override
   public String toString() {
       return "Direccion{" + "idDireccion=" + idDireccion + ", address=" + address + ", zipcode=" + zipcode + ", city=" + city + ", personaId=" + personaId + '}';
   }

   @Override
   public boolean equals(Object obj) {
       if (obj == null) {
           return false;
       }
       if (getClass() != obj.getClass()) {
           return false;
       }
       final Direccion other = (Direccion) obj;
       if (!Objects.equals(this.address, other.address)) {
           return false;
       }
       if (this.zipcode != other.zipcode) {
           return false;
       }
       if (!Objects.equals(this.city, other.city)) {
           return false;
       }
       return true;
   }

   
}
