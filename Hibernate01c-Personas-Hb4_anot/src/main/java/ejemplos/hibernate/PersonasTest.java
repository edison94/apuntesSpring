package ejemplos.hibernate;

import org.hibernate.*;

import ejemplos.hibernate.model.Persona;
import ejemplos.hibernate.util.HibernateUtil;
import ejemplos.hibernate.util.JdbcUtil;

public class PersonasTest {

    public static void main(String[] args) {

        // Creamos el SessionFactory y el objeto de Session hibernate
        // org.​hibernate.​Session
        // http://www.tutorialspoint.com/hibernate/hibernate_sessions.htm
        // Con este objeto tendremos una conexión con la BBDD
        Session session = null;
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        // tb vale SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        // org.​hibernate.​SessionFactory
        session = sessions.openSession();
        //Ahora ya tenemos una conexion

        // Hay varias sintaxis para SQL
        // http://matoosfe.com/blog/?p=73
        
        // Realiza la operacion
        Transaction tx = null;
        try {
            //tb hubiera valido poner solo   session.beginTransaction()
            tx = session.beginTransaction();

            Persona p1 = new Persona();
            p1.setNombre("Antonio131313");
            p1.setApellido("Santos R");
            //serializa el objeto
            session.save(p1);

            Persona p2 = new Persona();
            p2.setNombre("Carlos359898");
            p2.setApellido("Slim");
            session.save(p2);
            
            //Aprovecho el constructor creado
            session.save(new Persona("Bill359","Gates"));
            tx.commit();            

            // Comprobemos ahora si los objetos guardados son iguales a los que teníamos antes
            // Fijate como recupero un objeto de la BBDD
            Persona persona = (Persona) session.get(Persona.class, p1.getId());
            System.out.println("--- Persona " + persona.getId() + " recibida: " + persona.getNombre() + " "+persona.getApellido() );
            persona = (Persona) session.get(Persona.class, p2.getId());
            System.out.println("--- Persona " + persona.getId() + " recibida: " + persona.getNombre()+ " "+persona.getApellido());
            //Si no creo el objeto tx pondria session.getTransaction().commit()

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }
        
        // Para comprobar, se listan los datos de la BBDD mediante JDBC
        JdbcUtil.ejecutaQuery("select * from persona");
    }
}