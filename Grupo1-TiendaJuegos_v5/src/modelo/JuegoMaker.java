package modelo;

import java.util.ArrayList;
import java.util.List;

public class JuegoMaker {

	/**
	 * Crear juego con todos sus valores
	 * @param categoria Categoria
	 * @param titulo Titulo
	 * @param minNumJug Minimo de jugadores
	 * @param maxNumJug Maximo de jugadores
	 * @param descripcion Breve descripción
	 * @param rutaImg Ruta a la imagen del juego
	 * @param precio Precio
	 * @param cantidad Cantidad
	 * @param recomendado Está recomendado?
	 * @param vendidos cantidad de vendidos
	 * @return Juego
	 */
	public static Juego crear(Categoria categoria, String titulo, byte minNumJug, byte maxNumJug, String descripcion,
			String rutaImg, float precio, byte cantidad, boolean recomendado, short vendidos) {
		return new Juego(categoria, titulo, minNumJug, maxNumJug, descripcion, rutaImg, precio, cantidad, recomendado,
				vendidos);
	}

	/**
	 * Crear juegos con los minimos datos
	 * @param idJuego Identificador juego
	 * @return Juego
	 */
	public static Juego crearAux(int idJuego) {
		return new Juego(idJuego);
	}
	
	public static List<Juego> crearPruebas(){
		List<Juego> juegos = new ArrayList<>();
		juegos.add(crear(Categoria.Cartas, "Virus!", (byte) 2, (byte) 4,
				"Virus! es un juego en el que tendrás que construir un cuerpo humano mientras evitas que tus rivales infecten, destruyan o roben tus órganos.",
				"images/tranjis_games_virus.jpg", 13.50F, (byte) 3, true, (short) 20));
		juegos.add(crear(Categoria.Cartas, "¡COBARDES!", (byte) 2, (byte) 2,
				"Mientras la Villa y la Corte lloran la muerte del Rey, los Príncipes solo piensan hacerse con el poder del Reino. Estalla una guerra fratricida.",
				"images/juego-cobardes.png", 5F, (byte) 5, false, (short) 5));
		juegos.add(crear(Categoria.Rol, "MONDRIAN", (byte) 1, (byte) 5,
				"Pieter Cornelis Mondriaan, conocido como Piet Mondrian, fue un pintor vanguardista neerlandés. Evolucionó desde el naturalismo y el simbolismo hasta la abstracción, de la cual es el principal representante.",
				"images/mondrian-juego.png", 9.99F, (byte) 6, true, (short) 10));
		juegos.add(crear(Categoria.Tablero, "Red 7", (byte) 3, (byte) 8,
				"Puedes jugar una carta, cambiar las reglas o ambas. Pero, cuidado: ¡si no vas ganando al final de tu turno,  estás fuera!",
				"images/TRG-04red-1.jpg", 20F, (byte) 9, false, (short) 15));
		return juegos;
	}

}
