package com.seleniumexpress.lc.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AgeValidator.class )
public @interface Age {
	String message() default "{validation_msg_in_properties_file}";

	int min() default 18;

	int max() default 60;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
