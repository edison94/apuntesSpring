package service;


/**
*
* @author Antonio
*/
public class HolaMundoImp implements iHolaMundo {
	
   public void saludar(String nombre){
      System.out.println("Hola mundo, y en especial a "+nombre);
   }
}
