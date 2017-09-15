package spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Driver5 {
	
	@Autowired
	@Qualifier("coche")
	// @Qualifier es útil cuando se pueden emparejar varios beans
	//    si hay ambigüedad
	
	// Si no se hubiera colocado al lanzar en el main
	//   		Driver5 driver5 = (Driver5) context.getBean("driver5");
	// cuando crea el objero driver5 no sabría cual de las dos licencias podría utilizar
	//   y daría una excepción
	private iLicense5 license;
	
	public void tipoDeLicencia(){
		license.getLicencia();
	}
	
	public String toString() {
		return "Driver5 + " +  "@Qualifier para elegir licencia. ";
	}

	public iLicense5 getLicense() {
		return license;
	}

	public void setLicense(iLicense5 license) {
		this.license = license;
	}
	
	
	
}
