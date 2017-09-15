package spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("driver1")
public class Driver1 {

	private License1 license;
	
	@Autowired
	public void setLicense(License1 license) {
		this.license = license;
	}

	public License1 getLicense() {
		return license;
	}

	@Override
	public String toString() {
		return "Driver1 [license1=" + license + "]" + " @autowired por setter";
	}
	
	
}
