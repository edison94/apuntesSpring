package spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("driver2")
public class Driver2 {
	
	@Autowired
	private License2 license;
	
	public void setLicense(License2 license) {
		this.license = license;
	}

	public License2 getLicense() {
		return license;
	}

	@Override
	public String toString() {
		return "Driver2 [license2=" + license + "]" + " @autowired por atributos/propiedades";
	}
	
	
}
