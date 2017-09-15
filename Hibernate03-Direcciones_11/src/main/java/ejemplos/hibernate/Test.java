package ejemplos.hibernate;

import ejemplos.hibernate.model.Direccion;
import ejemplos.hibernate.model.Persona;
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

        // Creamos el SessionFactory y el objeto de Session hibernate
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        // tb vale SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        // org.​hibernate.​SessionFactory
        Session session = sessions.openSession();

        // Creamos los objetos y sus relaciones.
        System.out.println("-- Creando objetos de prueba");

        Persona p1 = new Persona("Antonio", "Santos" + Simulaciones.sufijoNombre());
        // Simulamos una direccion
        int zip =Simulaciones.randBetween(1, 50000);
        Direccion d1 = new Direccion("Calle" + Simulaciones.sufijoNombre(), zip, Provincias.getProvincia(""+zip));

        //Guardo la relacion. En mi caso es bidireccional
        p1.setDireccion(d1);
        d1.setPersonaId(p1);

        // Realiza la operación
        Transaction tx = null;
        try {
            System.out.println("--- Guardando datos");
            tx = session.beginTransaction();
            session.save(p1);
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
        JdbcUtil.ejecutaQuery("select * from relacion_11_direccion");
    }
}
