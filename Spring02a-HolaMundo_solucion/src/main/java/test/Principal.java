package test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.IComida;


/**
 *
 * @author Antonio
 */

public class Principal {
	
	public static void main(String[] args) {
       
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
          
		// Quiero comer sano
        IComida c = (IComida)context.getBean("ENDOCRINO");
        // Quiero saber sus calorias
        c.caloriasComida("manteca_cacahuete_con_mantequilla");
        
        ((ConfigurableApplicationContext)context).close();

    }

}





