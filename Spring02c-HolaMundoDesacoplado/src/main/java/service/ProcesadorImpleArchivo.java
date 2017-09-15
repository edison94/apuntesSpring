package service;

/**
*
* @author Antonio
*/
public class ProcesadorImpleArchivo implements IProcesador {

   public void procesar (String s){
       System.out.println("--- IMPRIMIENDO EN UN ARCHIVO ---");
       System.out.println(s);
   }
   
}