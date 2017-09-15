package service;

public class ProcesadorImpleConsola implements IProcesador {

    public void procesar (String s){
        System.out.println("--- IMPRIMIENDO EN UNA CONSOLA ---");
        System.out.println(s);
    }
	 

}
