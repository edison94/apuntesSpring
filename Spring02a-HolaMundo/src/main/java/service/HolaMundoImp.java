package service;


/**
*
* @author Antonio
*/
public class HolaMundoImp implements IHolaMundo {
	
   public void saludar(String nombre){
      System.out.println("Hola mundo, y en especial a "+nombre);
   }
}
