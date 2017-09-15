package ejemplos.hibernate;

import ejemplos.hibernate.model.Persona;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ejemplos.hibernate.util.HibernateUtil;

import org.hibernate.Query;

public class HQLTest {

    public static void main(String[] args) {
    	
        System.out.println("-------------------------------------------");
        System.out.println("--- Hibernate 06a. Trabajando con HQL ---");
        System.out.println("-------------------------------------------");    	

        // Creamos el SessionFactory y el objeto de Session hibernate
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        // tb vale SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        // org.​hibernate.​SessionFactory
        Session session = sessions.openSession();

        // PROBANDO EL HQL
        Query query;

        System.out.println("\n------ LISTADO DE PERSONAS");
        query = session.createQuery("from Persona");
        List<Persona> empList = query.list();
        for (Persona p : empList) {
            System.out.println(p);
        }

        System.out.println("\n------ DATOS DE UNA PERSONA");
        query = session.createQuery("from Persona where id= :id");
        query.setInteger("id", 2);
        //devuelve el objeto. Si no hay devuelve null
        Persona p1 = (Persona) query.uniqueResult();
        System.out.println(p1);

        System.out.println("\n------ PAGINACIÓN DE DATOS");
        query = session.createQuery("from Persona");
        //No uso el método list. Con el Fetch traigo sólo los id
        query.setFirstResult(0); //starts with 0
        //setMaxResults(int maxResults): 
        //Establece el nº máximo de objetos que van a retornarse.
        //Parecido al LIMIT
        //el setFecthSize es más óptimo... pero no todos lo implementan
        //query.setFetchSize(4);
        query.setMaxResults(2);
        empList = query.list();
        for (Persona p2 : empList) {
            System.out.println(p2);
        }

        System.out.println("\n------ ACTUALIZANDO DATOS v2");
        query = session.createQuery("update Persona set nombre= :nombre where id= :id");
        query.setParameter("nombre", "Antonio Machine5677777");
        query.setInteger("id", 1);
        int result = query.executeUpdate();
        System.out.println("--¿Exito? =" + result);
        //Compruebo
        query = session.createQuery("from Persona where id= :id");
        query.setInteger("id", 1);
        System.out.println((Persona) query.uniqueResult());

        System.out.println("\n------ BORRANDO DATOS");
        query = session.createQuery("delete from Persona where id= :id");
        query.setInteger("id", 6);
        //int result = query.executeUpdate();
        //System.out.println("--Employee Delete Status=" + result);
        //Fijate que si borras uno con FK no te deja
        // SI devuelve un 1 es que lo ha borrado
        // Si devuelve un cero es que no ha podido o no habia

        //join examples
        System.out.println("\n------ JOIN DATOS");
        //Los datos se cogen de la clase.. es decir p.nombre (es el atributo)
        //El p.direccion hace referencia al atributo que mapea a la otra clase
        query = session.createQuery("select p.nombre, p.apellido, d.city from Persona p "
                + "INNER JOIN p.direccion d");
        List<Object[]> list = query.list();
        for (Object[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }

        //order by example
        System.out.println("\n------ ORDENANDO DATOS");
        query = session.createQuery("from Persona p order by p.apellido desc");
        empList = query.list();
        for (Persona emp3 : empList) {
            System.out.println(emp3);
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