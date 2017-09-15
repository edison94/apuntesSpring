package ejemplos.hibernate;

import java.util.List;

import ejemplos.hibernate.model.Book;
import ejemplos.hibernate.service.BookService;

public class App {

	public static void main(String[] args) {
		
        System.out.println("---------------------------------");
        System.out.println("--- Hibernate 05 DAO (Libros) ---");
        System.out.println("---------------------------------");
        
		BookService bookService = new BookService();
		Book book1 = new Book("1", "La istoria interminable", "Michael Ende");
		Book book2 = new Book("2", "Parque Jurasico", "Michael Crichton");
		Book book3 = new Book("3", "Cronicas de la Dragonlance", "Margaret Weis & Tracy Hickman");
		Book book4 = new Book("4", "Sin noticias de Gurb", "Eduardo Mendoza");	
		System.out.println("--- PRUEBA 01: GUARDAR DATOS");		
		System.out.println("-- Guardando los datos en la BBDD");
		bookService.persist(book1);
		bookService.persist(book2);
		bookService.persist(book3);
		bookService.persist(book4);		
		System.out.println("--- PRUEBA 02: LISTAR DATOS");			
		List<Book> books1 = bookService.findAll();
		System.out.println("-- Los libros guardados son:");
		for (Book b : books1) {
			System.out.println("*" + b.toString());
		}
		System.out.println("\n\n--- PRUEBA 03: LOCALIZAR LIBRO");	
		String id1 = book1.getId();
		Book another = bookService.findById(id1);
		System.out.println("-- Encontrado libro con id " + id1 + ": " + another.toString());		
		System.out.println("\n\n--- PRUEBA 04: ACTUALIZAR DATOS");	
		System.out.println("-- Nombre actual del libro 01");
		System.out.println(bookService.findById(book1.getId()).toString());
		System.out.println("\n\n--- Madre mía, madre mía.. que fallo más gordo. Debo solucionarlo");			
		book1.setTitle("La istoria interminavle");
		bookService.update(book1);
		System.out.println("-- Libro 01 modificado: " +bookService.findById(book1.getId()).toString());
		System.out.println("\n\n--- Solucionado");			
		System.out.println("\n\n--- PRUEBA 05: BORRAR DATOS");
		System.out.println("-- Ahora tengo estos libros: " + bookService.findAll().size() + ".");		
		String id3 = book3.getId();
		bookService.delete(id3);
		System.out.println("-- Borrado el libro con id " + id3 + ".");
		System.out.println("-- Fijate que ahora solo tengo estos libros: " + bookService.findAll().size() + ".");
		System.out.println("\n\n--- PRUEBA 06: BORRAR TODOS LOS DATOS");
		System.out.println("-- Fijate que ahora solo tengo estos libros: " + bookService.findAll().size() + ".");		
		System.out.println("-- Borrando todo...");
		bookService.deleteAll();
		System.out.println("Num de libros encontrados ahora: " + bookService.findAll().size());
		 System.exit(0);
	}

	/** table creation statement: 
	 CREATE TABLE `book` ( id VARCHAR(50) NOT NULL, title
	 VARCHAR(50) default NULL, author VARCHAR(50) default NULL, PRIMARY KEY
	 (id) );
	 */
}
