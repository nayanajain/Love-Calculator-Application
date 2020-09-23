package com.seleniumexpress.api;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.seleniumexpress.api.validator.phonevalid;

public class CommunicationDTO {

	@NotBlank(message= "enter email address!!!!!")
	
	private String email;
	
	@Valid
	//@phonevalid(lower=30 ,upper=10 )
	private Phone phone;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
}
