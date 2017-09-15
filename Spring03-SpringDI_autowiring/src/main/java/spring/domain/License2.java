package spring.domain;

import org.springframework.stereotype.Component;

@Component
public class License2 {

	private String number="ABC2-12345";

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "License2 [number=" + number + "]";
	}	
	
	
}
