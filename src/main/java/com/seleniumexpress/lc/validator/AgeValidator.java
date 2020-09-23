package com.seleniumexpress.lc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

public class AgeValidator implements ConstraintValidator<Age, Integer>{

	
	private int min;
	private int max;
	
	@Override
	public void initialize(Age age) {
		// I can write post construct work here
		this.min=age.min();
		this.max=age.max();
		
	}
	@Override
	public boolean isValid(Integer age1, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(age1 == null)
		{
			return false;
		}
		if(age1< min || age1> max)
		{
			return false;
		}
		return true;
	}

}
