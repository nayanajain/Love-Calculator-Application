package com.seleniumexpress.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.seleniumexpress.api.Phone;

public class PhoneNoFormatter implements Formatter<Phone>{


	@Override
	public String print(Phone phone, Locale locale) {
		// TODO Auto-generated method stub
		System.out.println("inside the print method of phone class");
			return phone.getCountryCode()+"-"+phone.getUserNumber();
				}

	@Override
	public Phone parse(String completenumber, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		Phone phone=new Phone();	
		//split the phone number
		String[] phonenumber = completenumber.split("-");
		int index= completenumber.indexOf('-');
		
		
		if(index ==-1)
		{
			phone.setCountryCode("91");
			phone.setUserNumber(phonenumber[0]);
		}
		
		else if(index==0)
		{
			phone.setCountryCode("91");
			phone.setUserNumber(phonenumber[1]);
		}
		//assign into the new object
		else
		{
		phone.setCountryCode(phonenumber[0]);
		phone.setUserNumber(phonenumber[1]);
		System.out.println("inside parse method ");
		}
		return phone;
		
	}

}
