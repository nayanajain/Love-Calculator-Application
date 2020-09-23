package com.seleniumexpress.lc.service;

import org.springframework.stereotype.Service;

@Service
public class LcAppServiceImpl implements  LcAppService{

	
	public static final String word="FLAME";
	
	
	@Override
	public String calculatelove(String username, String crushname) {
		// TODO Auto-generated method stub
		
		int crushuser= (username+crushname).toCharArray().length;
		int wordlen=word.toCharArray().length;
		
		int rem=crushuser%wordlen;
		
		char letter=word.charAt(rem);
		String result=WhatsAns(letter);
		
	    return result;
	} 
	
	
	@Override
	public String WhatsAns(char letter) {
		// TODO Auto-generated method stub
		String result=null;
		if(letter=='F')
		{
			result= LoveCalcConstraint.F_CHAR_MEANING;
		} 
		
		else if(letter=='L')
		{
			result= LoveCalcConstraint.L_CHAR_MEANING;
		} 
		
		else if(letter=='A')
		{
			result=LoveCalcConstraint.A_CHAR_MEANING;
		}  
		
		else if(letter=='M')
		{
			result= LoveCalcConstraint.M_CHAR_MEANING;
		} 
		
		else if(letter=='E')
		{
			result= LoveCalcConstraint.E_CHAR_MEANING;
		} 
		return result;
	}

}
