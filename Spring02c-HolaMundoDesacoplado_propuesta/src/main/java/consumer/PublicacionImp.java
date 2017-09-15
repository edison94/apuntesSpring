package consumer;

import service.IRedSocial;

/**
 *
 * @author Antonio
 */
public class PublicacionImp implements IPublicacion {
	private IRedSocial red;
	
	public void setRed(IRedSocial red){
		this.red = red;
	}
	
	public void enviarMensaje(String mensaje) {        
		red.publicar(mensaje);
	}
}
