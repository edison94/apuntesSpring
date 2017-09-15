package test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import consumer.IPublicacion;


/**
 *
 * @author Antonio
 */

public class Principal {
	
	public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        IPublicacion pub = (IPublicacion)context.getBean("MENSAJE");
        pub.enviarMensaje("Estoy jugueteando con la IoC de Spring");
        ((ConfigurableApplicationContext)context).close();
    }

}





