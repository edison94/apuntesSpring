package service;

import org.springframework.stereotype.Component;

/**
*
* @author Antonio
*/

@Component("HOLAMUNDO")
public class HolaMundoImp implements IHolaMundo {
	
   public void saludar(String nombre){
      System.out.println("Hola mundo, y en especial a "+nombre);
   }
}
