package ejemplos.hibernate.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="persona")
//Implementa serializable para  que haya persistencia
public class Persona implements Serializable {
    @OneToMany(mappedBy = "personaId")
    private Collection<Direccion> relacion11DireccionCollection;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;    
    
    // Creamos una relacion 1:N indicando que la persona puede tener varios motes
    // En este ejercicio no aparece el ManyToOne y por lo tanto estoy obligado a hacer un JoinColumn
    //Eso quiere decir que a partir de una persona sé lo smotes, pero de un mote no sé las personas que lo tienen
    // http://docs.oracle.com/javaee/7/api/javax/persistence/OneToMany.html
    // http://en.wikibooks.org/wiki/Java_Persistence/OneToMany
    @OneToOne(mappedBy = "personaId", cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    private Direccion direccion;

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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "["+id+"] "+ nombre + " "+apellido;
    }

    public Persona(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        return true;
    }

    @XmlTransient
    public Collection<Direccion> getRelacion11DireccionCollection() {
        return relacion11DireccionCollection;
    }

    public void setRelacion11DireccionCollection(Collection<Direccion> relacion11DireccionCollection) {
        this.relacion11DireccionCollection = relacion11DireccionCollection;
    }



}