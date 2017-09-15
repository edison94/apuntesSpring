package modelo;

import java.util.ArrayList;

/**
 * Enumeracion de categorias de juegos de mesa
 * 
 * @author Grupo
 * @version v1.1
 *
 */
public enum Categoria {
	Cartas(1), Rol(2), Tablero(3);

	/**
	 * Indice de la enumeracion
	 */
	private final int id;

	/**
	 * Constructor
	 * @param indice Indice de la enumeración
	 */
	private Categoria(int indice) {
		this.id = indice;
	}

	
	public int getId() {
		return id;
	}
	/**
	 * Pide la Categoria a partir del indice
	 * @param index Indice de la enumeración
	 * @return Categoria
	 */
	public static Categoria getFromIndex(int index){
		switch (index) {
		case 1:
			return Cartas;
		case 2:
			return Rol;
		case 3:
			return Tablero;
		default:
			return null;
		}
	}
	
	/**
	 * Da un array con las distintas categorias
	 * @return
	 */
	public static ArrayList<Categoria> getCategorias(){
		ArrayList<Categoria> lista = new ArrayList<>();
		for (Categoria categoria : Categoria.values()) {
			lista.add(categoria);
		}
		return lista;
	}

}