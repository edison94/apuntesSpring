package ejemplos.hibernate;

import ejemplos.hibernate.model.Persona;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ejemplos.hibernate.util.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class CriteriaTest {

	 public static void main(String[] args) {
		 
	        System.out.println("-------------------------------------------");
	        System.out.println("--- Hibernate 06b. Trabajando con Criteria ---");
	        System.out.println("-------------------------------------------"); 		 

	        // Creamos el SessionFactory y el objeto de Session hibernate
	        SessionFactory sessions = HibernateUtil.getSessionFactory();
	        // tb vale SessionFactory sessions = new Configuration().configure().buildSessionFactory();
	        // org.​hibernate.​SessionFactory
	        Session session = sessions.openSession();

	        // PROBANDO EL HQL
	        Query query;

	        System.out.println("\n------ LISTADO DE PERSONAS");
	        /*
	         query = session.createQuery("from Persona");
	         List<Persona> empList = query.list();
	         for (Persona p : empList) {
	         System.out.println(p);
	         }
	         */
	        Criteria criteria = session.createCriteria(Persona.class);
	        List<Persona> empList = criteria.list();
	        for (Persona p : empList) {
	            System.out.println(p);
	        }

	        System.out.println("\n------ DATOS DE UNA PERSONA");
	        /*
	         query = session.createQuery("from Persona where id= :id");
	         query.setInteger("id", 3);
	         Persona p1 = (Persona) query.uniqueResult();
	         System.out.println(p1);
	         */
	        criteria = session.createCriteria(Persona.class)
	                .add(Restrictions.eq("id", 3));
	        // En la sintaxis de arriba se hace un unboxing a new Integer(3)
	        Persona p1 = (Persona) criteria.uniqueResult();
	        System.out.println(p1);

	        System.out.println("\n------ PAGINACIÓN DE DATOS");
	        /*
	         query = session.createQuery("from Persona");
	         query.setFirstResult(0); //starts with 0
	         query.setFetchSize(4);
	         empList = query.list();
	         for (Persona p2 : empList) {
	         System.out.println(p2);
	         }
	         */
	        empList = session.createCriteria(Persona.class)
	                .addOrder(Order.desc("id"))
	                .setFirstResult(0)
	                .setMaxResults(3)
	                .list();
	        for (Persona p2 : empList) {
	            System.out.println(p2);
	        }

	        System.out.println("\n------ FILTROS DE UNA PERSONA");
	        empList = session.createCriteria(Persona.class)
	                .add(Restrictions.like("apellido", "%L%"))
	                .list();
	        System.out.println("-- Empleados con una L en su apellido");
	        for (Persona p2 : empList) {
	            System.out.println(p2);
	        }

	        //join examples
	        System.out.println("\n------ JOIN DATOS");
	        /*        
	        //Los datos se cogen de la clase.. es decir p.nombre (es el atributo)
	        //El p.direccion hace referencia al atributo que mpea a l otra clase
	        query = session.createQuery("select p.nombre, p.apellido, d.city from Persona p "
	                + "INNER JOIN p.direccion d");
	        List<Object[]> list = query.list();
	        for (Object[] arr : list) {
	            System.out.println(Arrays.toString(arr));
	        }
	        */
	        
	        
	        criteria = session.createCriteria(Persona.class, "persona");
	        criteria.setFetchMode("persona.direccion", FetchMode.JOIN);
	        criteria.createAlias("persona.direccion", "direccion"); // inner join by default
	 
	        ProjectionList columns = Projections.projectionList()
	                        .add(Projections.property("nombre"))
	                        .add(Projections.property("direccion.city"));
	        criteria.setProjection(columns);
	 
	        List<Object[]> list = criteria.list();
	        for(Object[] arr : list){
	            System.out.println(Arrays.toString(arr));
	        }     
	        
	        //Tambien pueden realizarse acciones de delete/update
	        // http://www.thoughts-on-java.org/criteria-updatedelete-easy-way-to/


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