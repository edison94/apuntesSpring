package spring.service;

/**
*
* @author Antonio
*/

import org.springframework.stereotype.Component;

@Component("INSTAGRAM")
public class RedSocialInstagram implements IRedSocial {

	   public void publicar (String msg){
	       System.out.println("--- Publicando mensaje en Instagram ---");
	       System.out.println("- Compartiendo: "+msg);
	   }
	 

}
