package modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private List<ItemCarrito> items;
	public Carrito() {
		items = new ArrayList<>();
	}

	public List<ItemCarrito> getItems() {
		return items;
	}

	public void setItems(List<ItemCarrito> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
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
		Carrito other = (Carrito) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

	public int getItemCount() {
		int total = 0;
		for (ItemCarrito itemCarrito : items)
			total+= itemCarrito.getCantidad();
		return total;
	}

	public void add(Juego juego) {
		int index = items.indexOf(new ItemCarrito(juego));
		if (index != -1) {
			items.get(index).add();
		}else{
			items.add(new ItemCarrito(juego));
		}
	}
	
	public float getTotal(){
		float total = 0;
		for (ItemCarrito itemCarrito : items) {
			total+= itemCarrito.getSubtotal();
		}
		return total;
	}
	
}
