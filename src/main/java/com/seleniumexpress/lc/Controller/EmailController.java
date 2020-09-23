package com.seleniumexpress.lc.Controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
//import org.springframework.web.bind.annotation.SessionAttributes;

import com.seleniumexpress.api.EmailDTO;
import com.seleniumexpress.api.FeedbackDTO;
import com.seleniumexpress.api.UserInfoDTO;
import com.seleniumexpress.lc.service.LcEmailService;
import com.seleniumexpress.lc.service.LcEmailServiceImpl;


@Controller

public class EmailController { 

	
	Logger logger;
	@Autowired
	private LcEmailServiceImpl lcEmailService;
	
	//@RequestMapping("/sendEmail/{uName}")
//	public String sendEmail( @PathVariable("uName") String uName,  Model  model)
	//{
	@RequestMapping("/sendEmail")
		public String sendEmail( Model  model)	
		{
		model.addAttribute("emailDTO", new EmailDTO());
		
		return "send-email-page";
		
	}
	
	
	@RequestMapping("/process-email")
	public String processEmail(@SessionAttribute("userInfo")UserInfoDTO userInfoDTO, 
			@ModelAttribute EmailDTO emailDTO, HttpServletRequest request)
	{

		
		
				/*HttpSession session2=request.getSession();
				session2.setAttribute("email", emailDTO.getUserEmail());   */
		
		try
		{
			
		   lcEmailService.sendEmail(userInfoDTO.getuName(),emailDTO.getUserEmail(), "friend");
		}
		catch(Exception ex)
		{
			logger.info("\n\n\n-------------the exception is-------\n"+ex);
		}
	 
		return "show-email-page";
		
	}  
	
	
	@RequestMapping("/feedback")
	public String feedbackPage(Model model, FeedbackDTO fDTO) {
		// read the existing property by fetching it from dto
		
        model.addAttribute("feedback",fDTO);
		return "feedback";

	}     
	
	
	
	@RequestMapping("/thanks")
	public String ThanksPage(Model model, FeedbackDTO fDTO) {
		// read the existing property by fetching it from dto
		try
		{
		lcEmailService.sendFeedback(fDTO.getEmail(), fDTO.getName());
        
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("feedback",fDTO);
		return "thanks";
		
		

	}  
	
	@RequestMapping("/admin")
	public String adminPage(Model model, FeedbackDTO fDTO) {
		// read the existing property by fetching it from dto
		
       model.addAttribute(fDTO.getEmail());
       model.addAttribute(fDTO.getFeedback());
		return "feedback";

	}   
	
	
	



}
