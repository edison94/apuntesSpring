package ejemplos.hibernate;

import java.util.HashSet;
import java.util.Set;
import ejemplos.hibernate.model.Persona;
import ejemplos.hibernate.model.Telefonos;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ejemplos.hibernate.util.HibernateUtil;
import ejemplos.hibernate.util.JdbcUtil;
import ejemplos.hibernate.util.Simulaciones;

public class Test {

    public static void main(String[] args) {

        // Creamos el SessionFactory y el objeto de Session hibernate
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        // tb vale SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        // org.​hibernate.​SessionFactory
        Session session = sessions.openSession();

        // Creamos los objetos y sus relaciones.
        System.out.println("-- Creando objetos de prueba");
        Set<Telefonos> list1 = new HashSet<Telefonos>();
        list1.add(new Telefonos().simularTelefono());
        list1.add(new Telefonos().simularTelefono());
      

        Persona p1 = new Persona("Antonio","Santos"+ Simulaciones.sufijoNombre());
        p1.setTelefonos(list1);
        
        System.out.println("------ "+list1);        

        Set<Telefonos> list2 = new HashSet<Telefonos>();
        list2.add(new Telefonos().simularTelefono());
        list2.add(new Telefonos().simularTelefono());
 
        
        System.out.println("------ "+list2);

        Persona p2 = new Persona("Bill","Gates"+ Simulaciones.sufijoNombre());
        p2.setTelefonos(list2);

        // Realiza la operación
        Transaction tx = null;
        try {
            System.out.println("--- Guardando datos");
            tx = session.beginTransaction();
            session.save(p1);
            session.save(p2);
            System.out.println("--- OK. Realizo transaccion");
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                System.out.println("--- Fallo. Deshacer accion");
                tx.rollback();
            }
            System.out.println(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }

        // Listar los datos JDBC
        JdbcUtil.ejecutaQuery("select * from persona");
        JdbcUtil.ejecutaQuery("select * from relacion_1n_telefono");
    }
}