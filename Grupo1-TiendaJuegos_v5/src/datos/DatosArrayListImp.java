package datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import utilidades.GestorFicheros;
/**
 * 
 * @author Grupo 1
 *
 * @param <E> Valor generico para cualquier variable dentro de una colección
 */
public class DatosArrayListImp<E> implements IDatosArrayList<E>, Serializable {

	/**
	 * Valor para asegurar que la deserialización es de la clase correspondiente
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Enumeración de tipo lista generico
	 */
	private List<E> list = new ArrayList<>();

	/**
	 * Metodo que da la Lista
	 */
	public List<E> getList() {
		return list;
	}

	/**
	 * Metodo para escribir la lista
	 * @param list Lista que se quiere escribir 
	 */
	public void setList(List<E> list) {
		this.list = list;
	}

	/**
	 * Añade un elemento a la lista
	 */
	public void add(E element) {
		list.add(element);
	}

	/**
	 * Dado un elemento devuelve su indice si se encuentra en la lista (-1 si no lo encuentra)
	 */
	public int encontrar(E p) {
		int encontrado = -1;
		for (int i = 0; i < list.size(); i++) {
			E aux = list.get(i);
			if (aux.equals(p)) {
				encontrado = i;
			}
		}
		return encontrado;
	}
	
	/**
	 * Da un elemento de  la lista a partir de su indice
	 */
	public E get(int index) throws IndexOutOfBoundsException{
		return list.get(index);
	}

	/**
	 * Elimina un elemento de la lista
	 */
	public void eliminar(E e) {
		int pos = encontrar(e);
		if (pos != -1) {
			list.remove(pos);
		}
	}

	/**
	 * Imprime la lista por consola
	 */
	public void listar() {
		for (E e : list) {
			System.out.println(e);
		}
	}

	/**
	 * Busca si un elemento dado se encuentra a la lista
	 */
	public boolean existe(E p) {
		return encontrar(p) != -1;
	}

	
	public void modificar(E e) {
	}

	/**
	 * Imprime la lista por consola
	 */
	public void listado() {
		StringBuilder sb = new StringBuilder();
		for (E p : list) {
			sb.append(p.toString() + "\n");
		}
		System.out.println(sb.toString());
	}

	/**
	 * Guarda elemento en un fichero
	 */
	public void guardar(E e, String path) {
		GestorFicheros.guardarObjetToFile(e, path);
	}

	/**
	 * Carga una lista desde un fichero externo
	 */
	public void cargar(String path) {
		list = GestorFicheros.cargarFileToObjet(path);
	}

}
