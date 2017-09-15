package service;

/**
*
* @author Antonio
*/
public class ProcesadorImpleNet implements IProcesador {

   public void procesar (String s){
       System.out.println("--- IMPRIMIENDO PARA LA RED ---");
       System.out.println(s);
       //Abro socket (IP, puerto)
       //socket.send()
   }
   
}