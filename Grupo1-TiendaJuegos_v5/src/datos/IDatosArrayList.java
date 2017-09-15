package datos;

import java.util.List;

/**
 * Lista de funciones que se implementaran a DatosArrayListImp
 * @author Grupo1
 *
 * @param <E> Valor generico para cualquier variable dentro de una colección
 */
public interface IDatosArrayList<E> {
	
	/**
	 * Devuelve una lista de elementos genericos
	 * @return Lista de elementos genericos
	 */
	public List<E> getList();
	
	/**
	 * Carga una lista de elementos genericos
	 * @param Lista de elementos genericos
	 */
	public void setList(List<E> list);

	/**
	 * Añade un elemento en la lista
	 * @param element
	 */
	public void add(E element);

	/**
	 * Busca elemento en una lista y devuelve su indice
	 * @param element Elemento buscado en la lista
	 * @return Indice del elemento (-1 si no lo encuentra) 
	 */
	public int encontrar(E element);
	
	/**
	 * Devuelve el elemento en la posición index de la lista
	 * @param index Indice de la lista de la que se extrae el elemento
	 * @return Elemento de la lista en la posicion index
	 */
	public E get(int index);

	/**
	 * Elimina un elemento de la lista
	 * @param element Elemento que se quiere eliminar
	 */
	public void eliminar(E element);

	/**
	 * Comprueba si existe cierto elemento en una lista
	 * @param element Elemento que se quiere comprobar su existencia
	 * @return Booleano cuyo valor depende si lo ha encontrado o no
	 */
	public boolean existe(E element);

	public void modificar(E element);

	/**
	 * Printa la lista por consola
	 */
	public void listar();
	
	/**
	 * Guarda un elemento en un fichero externo
	 * @param element Elemento que se quiere guardar
	 * @param path Ruta donde se encuentra el fichero/o donde crear el fichero
	 */
	public void guardar(E element, String path);
	
	/**
	 * Carga la lista a partir de un fichero externo
	 * @param path Ruta donde se encuentra los datos almacenados
	 */
	public void cargar(String path);

}
