package test;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.config.AppConfig;
import spring.consumer.IPublicacion;


/**
 *
 * @author Antonio
 */

public class Principal {
	
	public static void main(String[] args) {

       AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        IPublicacion pub = (IPublicacion)context.getBean("MENSAJE");
        pub.enviarMensaje("Estoy jugueteando con la IoC de Spring... y con anotaciones");
        
        ((ConfigurableApplicationContext)context).close();
    }

}





