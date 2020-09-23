package com.seleniumexpress.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LcEmailServiceImpl implements LcEmailService {

	@Autowired
	private JavaMailSender javaMailSenderImpl;

	@Override
	public void sendEmail(String username, String userEmail, String result) {
		// TODO Auto-generated method stub

		SimpleMailMessage newmail = new SimpleMailMessage();
		newmail.setTo(userEmail);
		newmail.setSubject("Mail from spring tool suite");
		newmail.setText("Hii" + username + "\n The result predicted by the app is" + result);

		javaMailSenderImpl.send(newmail);

	}   
	
	
	public void sendFeedback(String email,String name)
	{
		 
		SimpleMailMessage newmail = new SimpleMailMessage();
		newmail.setTo(email);
		newmail.setSubject("Mail from spring tool suite");
		newmail.setText("Hii"+name+". We have received your feedback. Thanks for using our application");

		javaMailSenderImpl.send(newmail);
		
	}

}
