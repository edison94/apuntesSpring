package ejemplos.hibernate;

import ejemplos.hibernate.model.Direccion;
import ejemplos.hibernate.model.Persona;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ejemplos.hibernate.util.HibernateUtil;

import org.hibernate.FetchMode;
import org.hibernate.Query;


public class NamedQueriesTest {

	public static void main(String[] args) {
		
        System.out.println("-------------------------------------------");
        System.out.println("--- Hibernate 06c. Trabajando con NamedQueries ---");
        System.out.println("-------------------------------------------"); 		

        // Creamos el SessionFactory y el objeto de Session hibernate
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        // tb vale SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        // org.​hibernate.​SessionFactory
        Session session = sessions.openSession();

        // PROBANDO EL HQL
        Query query;

        System.out.println("\n------ LISTADO DE DIRECCIONES");
        query = session.getNamedQuery("Direccion.findAll");
        List<Direccion> addressList = query.list();
        for (Direccion addr : addressList) {
            System.out.println(addr);
        }

        System.out.println("\n------ LISTADO DE DIRECCIONES DE MADRID");
        query = session.getNamedQuery("Direccion.findByCity");
        query.setString("city", "Madrid");
        // System.out.println("-- " + query.getQueryString());
        addressList = query.list();
        for (Direccion addr : addressList) {
            System.out.println(addr);
        }

        // Realiza la operación
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
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

    }
}