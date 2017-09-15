package service;

/**
*
* @author Antonio
*/
public class RedSocialFacebook implements IRedSocial {

	   public void publicar (String msg){
	       System.out.println("--- Publicando mensaje en Facebook ---");
	       System.out.println("- Publicando en el muro: " + msg);
	   }
   
}