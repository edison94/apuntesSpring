package consumer;

import service.IRedSocial;

/**
 *
 * @author Antonio
 */
public class PublicacionImp implements IPublicacion {

	private IRedSocial redSocial;
	
	public PublicacionImp(){
		
	}

	public IRedSocial getRedSocial() {
		return redSocial;
	}

	public void setRedSocial(IRedSocial redSocial) {
		this.redSocial = redSocial;
	}

	public void enviarMensaje(String mensaje) {
		redSocial.publicar(mensaje);
	}
}
