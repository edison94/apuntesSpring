package spring.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.service.IRedSocial;

/**
 *
 * @author Antonio
 */

@Component("MENSAJE")
public class PublicacionImp implements IPublicacion {
	
	@Autowired
	@Qualifier("TWITTER")
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
