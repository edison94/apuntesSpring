package modelo;

import java.io.Serializable;

/**
 * Clase juego
 * 
 * @author Lluis
 * @version v1.0
 *
 */
public class Juego implements Comparable<Juego>, Serializable {
	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identificador del juego
	 */
	private int id;
	/**
	 * Categoria del juego
	 */
	private Categoria categoria;
	/**
	 * Nombre del juego
	 */
	private String titulo;
	/**
	 * Número mínimo de jugadores
	 */
	private byte minNumJug;
	/**
	 * Número máximo de jugadores
	 */
	private byte maxNumJug;
	/**
	 * Brebe descripción del producto
	 */
	private String descripcion;
	/**
	 * Ruta hacia donde se encuentra la imagen del juego
	 */
	private String rutaImg;
	/**
	 * Precio del producto
	 */
	private float precio;
	/**
	 * Cantidad del producto
	 */
	private byte cantidad;
	/**
	 * ¿Está recomendado?
	 */
	private boolean recomendado;
	/**
	 * cantidad que se han vendido
	 */
	private short vendidos;
	/**
	 * cantidad que se han vendido
	 */
	private static int count = 0;

	/**
	 * Constructor vacio
	 */
	public Juego() {
		super();
	}

	/**
	 * Constructor con identificador
	 * 
	 * @param id
	 *            identificador del juego (único)
	 */
	public Juego(int id) {
		super();
		this.id = id;
	}

	/**
	 * Constructor lleno
	 * 
	 * @param id
	 *            identificador del juego (único)
	 * @param categoria
	 *            categoria del juego
	 * @param titulo
	 *            nombre del juego
	 * @param minNumJug
	 *            número mínimo de jugadores
	 * @param maxNumJug
	 *            número máximo de jugadores
	 * @param descripcion
	 *            breve deescripción del juego
	 * @param rutaImg
	 *            ruta hacia donde se encuentra la imagen del juego
	 * @param precio
	 *            precio del producto
	 * @param cantidad
	 *            cantidad del producto
	 * @param recomendado
	 *            ¿está recomendado?
	 * @param vendidos
	 *            cuantos se han vendidos
	 */
	public Juego(Categoria categoria, String titulo, byte minNumJug, byte maxNumJug, String descripcion, String rutaImg,
			float precio, byte cantidad, boolean recomendado, short vendidos) {
		this.id = ++count;
		this.categoria = categoria;
		this.titulo = titulo;
		this.minNumJug = minNumJug;
		this.maxNumJug = maxNumJug;
		this.descripcion = descripcion;
		this.rutaImg = rutaImg;
		this.precio = precio;
		this.cantidad = cantidad;
		this.recomendado = recomendado;
		this.vendidos = vendidos;
	}

	public Juego(String titulo, String descripcion, String rutaImg) {
		this.id = ++count;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.rutaImg = rutaImg;
	}

	public int getId() {
		return id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public byte getMinNumJug() {
		return minNumJug;
	}

	public void setMinNumJug(byte minNumJug) {
		this.minNumJug = minNumJug;
	}

	public byte getMaxNumJug() {
		return maxNumJug;
	}

	public void setMaxNumJug(byte maxNumJug) {
		this.maxNumJug = maxNumJug;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRutaImg() {
		return rutaImg;
	}

	public void setRutaImg(String rutaImg) {
		this.rutaImg = rutaImg;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public byte getCantidad() {
		return cantidad;
	}

	public void setCantidad(byte cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isRecomendado() {
		return recomendado;
	}

	public void setRecomendado(boolean recomendado) {
		this.recomendado = recomendado;
	}

	public short getVendidos() {
		return vendidos;
	}

	public void setVendidos(short vendidos) {
		this.vendidos = vendidos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juego other = (Juego) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(Juego j) {
		if (vendidos > j.vendidos)
			return 1;
		else if (vendidos < j.vendidos)
			return -1;
		else
			return 0;
	}

}