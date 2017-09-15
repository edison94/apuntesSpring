package ejemplos.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object. Valida para Hibernate 4.x
 *
 * @author Antonio
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    // private static StandardServiceRegistryBuilder serviceRegistryBuilder;
    // Para HB 4.0 hubiera sido
    // ServiceRegistry serviceRegistry
    
    // Mas informaci�n sobre versiones obsoletas
    // http://www.codejava.net/frameworks/hibernate/building-hibernate-sessionfactory-from-service-registry

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            
            // Si necesitamos indicar la ruta del xml usariamos
            // configuration.configure("hibernate.cfg.xml");
            // En las primeras versiones de Hibernate funciona esto
            // ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            // sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
            // Pero en Hibernate 4.3 esta obsoleto. Puedes usar esto         
            
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

            // If you miss the below line then it will complaing about a missing dialect setting
            serviceRegistryBuilder.applySettings(configuration.getProperties());

            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            

        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
     
}
