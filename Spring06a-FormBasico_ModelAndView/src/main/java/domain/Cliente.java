package domain;

import java.io.Serializable;

public class Cliente implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
    private String id;
    private String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", id=" + id + ", password="
				+ password + "]";
	}
    
    

}
