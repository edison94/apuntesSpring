package test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import config.ComidaConfig;
import service.IComida;


/**
 *
 * @author Antonio
 */

public class Principal {
	
	public static void main(String[] args) {
       
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ComidaConfig.class);
		// Quiero comer sano
        IComida c = (IComida)context.getBean("ENDOCRINO");
        // Quiero saber sus calorias
        c.caloriasComida("garbanzos");
        ((ConfigurableApplicationContext)context).close();
    }

}





