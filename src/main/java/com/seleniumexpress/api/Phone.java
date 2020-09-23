package com.seleniumexpress.api;

import javax.validation.constraints.NotBlank;

public class Phone {
//	@NotBlank(message = "country code blank nhiii")
	private String countryCode;
	
	// @NotBlank
	private String userNumber;
	
	
	public String getCountryCode() {
		
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	
	@Override
	public String toString() {
		return countryCode+ "-" + userNumber;
	}

}
