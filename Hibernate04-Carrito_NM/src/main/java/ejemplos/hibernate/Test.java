package ejemplos.hibernate;

import java.util.HashSet;
import java.util.Set;

import ejemplos.hibernate.model.Carrito;
import ejemplos.hibernate.model.Producto;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ejemplos.hibernate.util.HibernateUtil;
import ejemplos.hibernate.util.JdbcUtil;
import ejemplos.hibernate.util.Simulaciones;
import ejemplos.hibernate.util.Provincias;

public class Test {

    public static void main(String[] args) {


        System.out.println("-------------------------------------------");
        System.out.println("--- Hibernate many to many (Annotation) ---");
        System.out.println("-------------------------------------------");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        // Creo unos casos de prueba
        Carrito carrito = new Carrito();
        carrito.carritoPrueba();

        Producto prod1 = new Producto();
        prod1.productoPrueba();
        System.out.println("--- " + prod1);
        Producto prod2 = new Producto();
        prod2.productoPrueba();
        System.out.println("--- " + prod2);
      

        Set<Producto> productos = new HashSet<Producto>();
        productos.add(prod1);
        productos.add(prod2);
        System.out.println("--- Productos a guardar: "+productos.size());
        System.out.println("--- Listado: "+productos);        

        //Hago la relacion
        carrito.setProductoSet(productos);
        System.out.println("--- " + carrito);

        //Fijate que sólo guardo uno de ellos
        session.save(carrito);

        session.getTransaction().commit();
        System.out.println("--- Transacción realizada");

        // Listar los datos para comprobar
        System.out.println("------------- VOLCADO DE LA BBDD -----------------");
        JdbcUtil.ejecutaQuery("select * from relacion_nm_carrito");
        JdbcUtil.ejecutaQuery("select * from relacion_nm_producto");
        JdbcUtil.ejecutaQuery("select * from relacion_nm_carrito_producto");
    }
}
