package com.seleniumexpress.api;

import java.util.Arrays;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.seleniumexpress.lc.validator.Age;





public class uuserInfoDTO {
	@NotEmpty(message=" cannot be empty")

	private String uName;
	private String user;
		private char[] passwd;
	private String gen;
		private String Country;
	private String hobby;
	
	
	@Age(min=30 ,max=40 )
	private Integer age;
	
	
	@Valid
	private CommunicationDTO communicationDTO;
	
	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public uuserInfoDTO()
	{
		System.out.println("Object created");
		
	}

	public String getuName() {
		return uName;
	}
	
	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	
	public char[] getPasswd() {
		return passwd;
	}

	public void setPasswd(char[] passwd) {
		this.passwd = passwd;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	@Override
	public String toString() {
		return "userInfoDTO [uName=" + uName + ", user=" + user + ", passwd=" + Arrays.toString(passwd) + ", gen=" + gen
				+ ", Country=" + Country + "]";
	}

	public CommunicationDTO getCommunicationDTO() {
		return communicationDTO;
	}

	public void setCommunicationDTO(CommunicationDTO communicationDTO) {
		this.communicationDTO = communicationDTO;
	}

	
		
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	
}
