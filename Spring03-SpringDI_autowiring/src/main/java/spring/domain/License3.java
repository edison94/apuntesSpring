package spring.domain;

import org.springframework.stereotype.Component;

@Component
public class License3 {

	private String number="ABC3-12345";
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "License3 [number=" + number + "]";
	}
	
}
