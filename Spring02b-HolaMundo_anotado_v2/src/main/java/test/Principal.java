package test;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.HolaMundoConfig;
import service.iHolaMundo;


/**
 *
 * @author Antonio
 */

public class Principal {
	
	public static void main(String[] args) {
        
		// En este caso no cargamos configuracion XML realmente. Se indicarán anotaciones
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(HolaMundoConfig.class);
          
        iHolaMundo h = (iHolaMundo)context.getBean("HOLAMUNDO");
        h.saludar("Antonio");
        
        ((ConfigurableApplicationContext)context).close();
    }

}





