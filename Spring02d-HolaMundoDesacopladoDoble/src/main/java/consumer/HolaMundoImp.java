package consumer;

import service.IEncriptador;
import service.IProcesador;

/**
 *
 * @author Antonio
 */
public class HolaMundoImp implements IHolaMundo {

	private IProcesador procesador;
	private IEncriptador encriptador;

	/*
	 * DI via Constructor Injection
	 */
	public HolaMundoImp(IEncriptador encriptador) {
		this.encriptador = encriptador;
	}

	public IProcesador getProcesador() {
		return procesador;
	}

	/*
	 * DI via Setter
	 */
	public void setProcesador(IProcesador procesador) {
		this.procesador = procesador;
	}

	public void saludar(String msg) {
		encriptador.encriptar(msg);
		procesador.procesar("Enviando... " + msg);
	}
}
