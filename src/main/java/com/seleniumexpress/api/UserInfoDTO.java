package com.seleniumexpress.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {

	@Size(min = 2, max = 20)
	private String uName;

	@NotBlank(message = " * please fill detail")
	private String crushName;

	@AssertTrue(message = "you have to agree to our term and condition")
	private boolean termcondition;

	public UserInfoDTO() {
		System.out.println("Object created");

	}

	public boolean isTermcondition() {
		return termcondition;
	}

	public void setTermcondition(boolean termcondition) {
		this.termcondition = termcondition;
	}

	public String getuName() {
		return uName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [uName=" + uName + ", crushName=" + crushName + "]";
	}

}
