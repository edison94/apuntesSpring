/**
 * 
 */
package utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase encargada de guardar/cargar datos en/de ficheros externos
 * @author Grupo1
 *
 */
public class GestorFicheros {

	/**
	 * Guarda un objeto en un fichero externo
	 * @param element Elemento que se guarda
	 * @param path Ruta hacia el fichero externo (en caso de que no exista se creara)
	 */
	public static <E> void guardarObjetToFile(E element, String path) {
		try (FileOutputStream f = new FileOutputStream(new File(path)); ObjectOutputStream s = new ObjectOutputStream(f);) {
			s.writeObject(element);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga un elemento guardado en un fichero externo
	 * @param path Ruta hacia el fichero externo
	 * @return Objeto guardado en ese fichero
	 */
	@SuppressWarnings("unchecked")
	public static <E> E cargarFileToObjet(String path) {
		E element = null;
		try (FileInputStream f = new FileInputStream(new File(path)); ObjectInputStream s = new ObjectInputStream(f);) {
			element = (E) s.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return element;
	}
}
