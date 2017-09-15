package model;

public class Libro {
	
	private String nombre;
	private String autor;
	private String sinopsis;
	
	public Libro() {
		super();
	}

	public Libro(String nombre, String autor, String sinopsis) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.sinopsis = sinopsis;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	@Override
	public String toString() {
		return "Libro [nombre=" + nombre + ", autor=" + autor + ", sinopsis=" + sinopsis + "]";
	}

}
