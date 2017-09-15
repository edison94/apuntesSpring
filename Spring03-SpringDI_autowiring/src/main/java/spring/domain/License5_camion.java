package spring.domain;

import org.springframework.stereotype.Component;

@Component("camion")
public class License5_camion implements iLicense5 {

	public void getLicencia() {
		System.out.println("Tengo licencia para camiones");
		
	}

}
