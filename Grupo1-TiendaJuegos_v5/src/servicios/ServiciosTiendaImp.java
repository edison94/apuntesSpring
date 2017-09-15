package servicios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import datos.DatosArrayListImp;
import datos.IDatosArrayList;
import modelo.Carrito;
import modelo.Categoria;
import modelo.Juego;
import modelo.JuegoMaker;

/**
 * Clase de servicios
 * @author Grupo1
 *
 */
public class ServiciosTiendaImp implements IServiciosTienda, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 906177845194308703L;
	/**
	 * Lista de juegos con acceso a funciones especiales de DatosArrayListImp
	 */
	private IDatosArrayList<Juego> datosJuegos = new DatosArrayListImp<>();

	/**
	 * Pide la lista de juegos
	 */
	@Override
	public List<Juego> getListaJuegos() {		
		return datosJuegos.getList();
	}

	/**
	 * Busca un Juego de la lista a partir de su id
	 */
	@Override
	public Juego getJuego(int idJuego) {
		return datosJuegos.get(datosJuegos.encontrar(JuegoMaker.crearAux(idJuego)));
	}

	/**
	 * Funcion para recomendar / Disabled
	 */
	@Override
	public boolean recomendar(int idJuego) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Añade un juego a la lista
	 */
	@Override
	public boolean addJuego(Juego juego) {
		try {
			datosJuegos.add(juego);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Añade un juego sin instanciarlo
	 */
	public boolean addJuego(Categoria categoria, String titulo, byte minNumJug, byte maxNumJug, String descripcion,
			String rutaImg, float precio, byte cantidad, boolean recomendado, short vendidos) {
		return addJuego(JuegoMaker.crear(categoria, titulo, minNumJug, maxNumJug, descripcion, rutaImg, precio,
				cantidad, recomendado, vendidos));
	}

	/**
	 * Actualiza informació´n de un juego / Disabled
	 */
	@Override
	public boolean updateJuego(Juego juego) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Elimina un juego de la lista
	 */
	@Override
	public boolean removeJuego(int idJuego) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Buscar juegos de una categoria
	 */
	@Override
	public List<Juego> buscarJuegosCategoria(int idCategoria) {
		List<Juego> list = getListaJuegos();
		List<Juego> listAux = new ArrayList<>();
		for (Juego juego : list) {
			if (juego.getCategoria().getId() == idCategoria)
				listAux.add(juego);
		}
		return listAux;
	}

	/**
	 * busca juegos por titulo
	 */
	@Override
	public List<Juego> buscarJuegosTitulo(String str) {
		List<Juego> list = getListaJuegos();
		List<Juego> listAux = new ArrayList<>();
		for (Juego juego : list) {
			if (juego.getTitulo().toLowerCase().contains(str.toLowerCase()))
				listAux.add(juego);
		}
		return listAux;
	}
	
	/**
	 * Busca juegos por numero de jugadores
	 */
	@Override
	public List<Juego> buscarJuegosNumJugadores(byte numJugadores) {
		List<Juego> list = getListaJuegos();
		List<Juego> listAux = new ArrayList<>();
		for (Juego juego : list) {
			if ((numJugadores>=juego.getMinNumJug())&&(numJugadores<=juego.getMaxNumJug()))
				listAux.add(juego);
		}
		return listAux;
	}

	@Override
	public List<Juego> listaTop() {
		List<Juego> listAux = new ArrayList<>(getListaJuegos());
		Collections.sort(listAux);
		return listAux.subList(0, 3);
	}

	/**
	 * Lista los juegos recomendados
	 */
	@Override
	public List<Juego> listaRecomendado() {
		List<Juego> list = getListaJuegos();
		List<Juego> listAux = new ArrayList<>();
		for (Juego juego : list) {
			if (juego.isRecomendado())
				listAux.add(juego);
		}
		return listAux;
	}

	/**
	 * Añade juego al carrito
	 */
	@Override
	public boolean addJuegoCarrito(Carrito carro, Juego juego, int catidad) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Actualiza estado del juego del carrito
	 */
	@Override
	public boolean updateJuegoCarrito(Carrito carro, Juego juego, int catidad) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Elimina juego del carrito
	 */
	@Override
	public boolean removeJuegoCarrito(Carrito carro, Juego juego) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * realiza compra
	 */
	@Override
	public boolean comprar(Carrito carro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setListaJuegos(List<Juego> juegos) {
		datosJuegos.setList(juegos);
	}

}
