package consumer;

import service.IProcesador;


/**
*
* @author Antonio
*/
public class HolaMundoImp implements IHolaMundo {
	
	private IProcesador procesador;

    public IProcesador getProcesador() {
        return procesador;
    }

	/*
	 * DI via Setter
	 */
    public void setProcesador(IProcesador procesador) {
        this.procesador = procesador;
    }

    public void saludar(String nombre){
       //System.out.println("Hola mundo, "+nombre);
       procesador.procesar("Hola mundo, y en especial a "+nombre);
    }
}
