package service;

/**
*
* @author Antonio
*/
public class RedSocialTwitter implements IRedSocial {

   public void publicar (String msg){
       System.out.println("--- Publicando mensaje en Twitter ---");
       System.out.println("- Twitteando: " + msg);
   }
   
}