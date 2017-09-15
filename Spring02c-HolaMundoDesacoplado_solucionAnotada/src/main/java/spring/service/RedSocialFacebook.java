package spring.service;

import org.springframework.stereotype.Component;

/**
*
* @author Antonio
*/

@Component("FACEBOOK")
public class RedSocialFacebook implements IRedSocial {

	   public void publicar (String msg){
	       System.out.println("--- Publicando mensaje en Facebook ---");
	       System.out.println("- Publicando en el muro: " + msg);
	   }
   
}