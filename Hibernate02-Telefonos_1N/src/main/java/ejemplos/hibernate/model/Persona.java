package ejemplos.hibernate.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="persona")
//Implementa serializable para  que haya persistencia
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;    
    
    // Creamos una relacion 1:N indicando que la persona puede tener varios motes
    // En este ejercicio no aparece el ManyToOne y por lo tanto estoy obligado a hacer un JoinColumn
    // Eso quiere decir que a partir de una persona sé los teléfonos, pero de un teléfono no sé las personas que lo tienen
    // http://docs.oracle.com/javaee/7/api/javax/persistence/OneToMany.html
    // http://en.wikibooks.org/wiki/Java_Persistence/OneToMany
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    private Set<Telefonos> telefonos;

    public Persona() {
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Telefonos> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<Telefonos> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefonos=" + telefonos + '}';
    }

}