package spring.service;

import org.springframework.stereotype.Component;

/**
*
* @author Antonio
*/

@Component("TWITTER")
public class RedSocialTwitter implements IRedSocial {

   public void publicar (String msg){
       System.out.println("--- Publicando mensaje en Twitter ---");
       System.out.println("- Twitteando: " + msg);
   }
   
}