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
          
		// Quiero comer sano. Ej lentejas
        IComida comida = (IComida)context.getBean("comida_consola");
        // Quiero saber sus calorias
        comida.caloriasComida("judias");
        ((ConfigurableApplicationContext)context).close();

    }

}





