package com.seleniumexpress.api.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.seleniumexpress.lc.validator.AgeValidator;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneValidalidator.class )
public @interface phonevalid {
	
	
	int lower() default 13;
	int upper()default 13;
	
	
	String message() default "{Your Phone no should be exactly 10 digit}";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}

