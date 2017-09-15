package spring.domain;

import org.springframework.stereotype.Component;

@Component
public class License4 {

	private String number="ABC4-12345";
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "License4 [number=" + number + "]";
	}
	
}
