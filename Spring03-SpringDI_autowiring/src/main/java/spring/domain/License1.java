package spring.domain;

import org.springframework.stereotype.Component;

@Component
public class License1 {

	private String number="ABC1-12345";

	@Override
	public String toString() {
		return "License1 [number=" + number + "]";
	}
	
	//setters, getters
}
