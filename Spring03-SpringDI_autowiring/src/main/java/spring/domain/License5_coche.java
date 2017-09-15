package spring.domain;

import org.springframework.stereotype.Component;

@Component("coche")
public class License5_coche implements iLicense5 {

	public void getLicencia() {
		System.out.println("Tengo licencia para coches");
		
	}

}
