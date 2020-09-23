package com.seleniumexpress.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.seleniumexpress.lc.validator.Age;

public class PhoneValidalidator implements ConstraintValidator<phonevalid,Integer> {

	private int lower;
	private int upper;
	
	@Override
	public void initialize(phonevalid pv) {
		// I can write post construct work here
		this.lower=pv.lower();
		this.upper=pv.upper();
	}

	
	@Override
	public boolean isValid(Integer p1, ConstraintValidatorContext context) {
		
		if(p1==null)
		{
			return false;
		}
		else if(p1>upper || p1< lower)
		{
			return false;
		}
			
			
		return true;
	}

}
