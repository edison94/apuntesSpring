package modelo;

public class ItemCarrito{
	private Juego juego;
	private byte cantidad;
	
	public ItemCarrito(Juego juego, byte cantidad) {
		this.juego = juego;
		this.cantidad = cantidad;
	}
	
	public ItemCarrito(Juego juego) {
		this(juego,(byte)1);
	}
	
	public Juego getJuego() {
		return juego;
	}
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	public byte getCantidad() {
		return cantidad;
	}
	public void setCantidad(byte cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((juego == null) ? 0 : juego.hashCode());
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
		ItemCarrito other = (ItemCarrito) obj;
		if (juego == null) {
			if (other.juego != null)
				return false;
		} else if (!juego.equals(other.juego))
			return false;
		return true;
	}
	
	public void add(){
		cantidad++;
	}
	
	public void remove(){
		cantidad--;
	}

	public float getSubtotal() {
		return cantidad * juego.getPrecio();
	}
}
