package com.seleniumexpress.lc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.seleniumexpress.api.uuserInfoDTO;

public class UserNameValidate implements Validator{

	
	//check if username support the given object
	@Override
	public boolean supports(Class<?> clazz) {
		
		return uuserInfoDTO.class.equals(clazz);
	}
    //write custom validator logic
	
	
	@Override
	public void validate(Object obj, Errors errors) {
		
		//to check if the field is null
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uName", "uName.empty", "empty hai bhayaaa");
//	   String thename = ((uuserInfoDTO)obj).getuName();
//		
//		if(!thename.contains("_"))
//		{
//			errors.rejectValue("thename", "thename.invalidString", "insert _ in name");
//			
//			
//		}
		
ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "communicationDTO.email.empty", "email empty hai bhayaaa");
//
//		
	String emailadd=((uuserInfoDTO)obj).getCommunicationDTO().getEmail();
	if(!emailadd.contains("seleniumexpress.com"))
		{
	errors.rejectValue("communicationDTO.email", "email.invalidString");
		}
		
		
	}

}
