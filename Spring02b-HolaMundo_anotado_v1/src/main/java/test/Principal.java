package test;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppConfig;
import service.IHolaMundo;


/**
 *
 * @author Antonio
 */

public class Principal {
	
	public static void main(String[] args) {
		
		// En este caso no cargamos configuracion XML realmente. Se indicarán anotaciones
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        IHolaMundo h = (IHolaMundo)context.getBean("HOLAMUNDO");
        h.saludar("Antonio Machine");
        
        ((ConfigurableApplicationContext)context).close();
    }

}





