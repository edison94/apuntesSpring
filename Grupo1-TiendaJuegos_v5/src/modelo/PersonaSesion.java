package modelo;

/**
 * Clase persona
 * @author Lluis
 * @version v1.0
 *
 */
public class PersonaSesion {
	/**
	 * Alias de persona
	 */
	private String alias;
	/**
	 * Contraseña de persona
	 */
	private String password;
	
	
	/**
	 * Constructor vacio
	 */
	public PersonaSesion() {
		super();
	}

	/**
	 * Constructor lleno
	 * @param alias Alias de la persona
	 * @param password Contraseña de la persona
	 */
	public PersonaSesion(String alias, String password) {
		super();
		this.alias = alias;
		this.password = password;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaSesion other = (PersonaSesion) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
