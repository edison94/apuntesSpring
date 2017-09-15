package servicios;

import java.util.List;

import modelo.Carrito;
import modelo.Categoria;
import modelo.Juego;

public interface IServiciosTienda {

	/**
	 * Busca juego de la lista por su id
	 * @param idJuego Identificador del juego
	 * @return Juego correspondiente al id
	 */
	public Juego getJuego(int idJuego);

	/***
	 * Lista los juegos
	 * @return Lista de juegos
	 */
	public List<Juego> getListaJuegos();
	
	/***
	 * Lista los juegos
	 * @param Lista de juegos
	 */
	public void setListaJuegos(List<Juego> juegos);

	/**
	 * Busca juegos por categoria
	 * @param idCategoria Categoria que se quieren ver los juegos
	 * @return Listado de juegos correspondientes a esa categoria
	 */
	public List<Juego> buscarJuegosCategoria(int idCategoria);

	/**
	 * Busca juegos a partir de su titulo
	 * @param srt Nomre del juego a buscar
	 * @return Listado de juegos con ese nombre
	 */
	public List<Juego> buscarJuegosTitulo(String srt);
	
	/**
	 * Busca juegos por numero de jugadores
	 * @param numJugadores Numero de jugadores deseados
	 * @return Lista de juegos que cumplen la especificació´n
	 */
	public List<Juego> buscarJuegosNumJugadores(byte numJugadores);

	/**
	 * Hace una lista ordenada de los juegos
	 * @return
	 */
	public List<Juego> listaTop();

	/**
	 * Hace una lista de los juegos recomendados
	 * @return
	 */
	public List<Juego> listaRecomendado();

	/**
	 * Añade juego al carrito
	 * @param carro Carrito al que añadir el juego
	 * @param juego Objeto juego
	 * @param catidad Cantidad de objetos de ese tipo
	 * @return Booleano que representa si se ha realizado la operacion correctamente
	 */
	public boolean addJuegoCarrito(Carrito carro, Juego juego, int catidad);


	/**
	 * Modifica juego del carrito
	 * @param carro Carrito al que se modifica el juego
	 * @param juego Objeto juego
	 * @param catidad Cantidad de objetos de ese tipo
	 * @return Booleano que representa si se ha realizado la operacion correctamente
	 */
	public boolean updateJuegoCarrito(Carrito carro, Juego juego, int catidad);

	/**
	 * Elimina juego del carrito
	 * @param carro Carrito del que se desea eliminar el juego
	 * @param juego Juego que se desea eliminar
	 * @return Se ha realizado correctamenta?
	 */
	public boolean removeJuegoCarrito(Carrito carro, Juego juego);

	/**
	 * Realizar compra
	 * @param carro Carrito del que comprar
	 * @return Se ha realizado correctamente?
	 */
	public boolean comprar(Carrito carro);

	/**
	 * Recomendar juego a partir de su id
	 * @param idJuego Identificador del Juego
	 * @return Se ha realizado correctamente?
	 */
	public boolean recomendar(int idJuego);

	/**
	 * Añadir Juego
	 * @param juego Juego
	 * @return Se ha realizado correctamente? 
	 */
	public boolean addJuego(Juego juego);

	/**
	 * Añadir juego sin instanciar
	 * @param categoria Categoria del juego
	 * @param titulo Titulo del juego
	 * @param minNumJug numero minimo de jugadores
	 * @param maxNumJug numero máximo de jugadores
	 * @param descripcion Breve descripción del juego
	 * @param rutaImg Ruta a la imagen del juego
	 * @param precio Precio del juego
	 * @param cantidad Cantidad de juegos
	 * @param recomendado Está recomendado?
	 * @param vendidos Cuantos se han vendido
	 * @return Se ha realizado correctamente?
	 */
	public boolean addJuego(Categoria categoria, String titulo, byte minNumJug, byte maxNumJug, String descripcion,
			String rutaImg, float precio, byte cantidad, boolean recomendado, short vendidos);

	/**
	 * Actualizar juego
	 * @param juego Juego
	 * @return Se ha realizado correctamente?
	 */
	public boolean updateJuego(Juego juego);

	/**
	 * Eliminar juego de la lista
	 * @param idJuego identificador del juego
	 * @return Se ha realizado correctamente?
	 */
	public boolean removeJuego(int idJuego);

}
