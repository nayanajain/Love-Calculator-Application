package com.seleniumexpress.lc.config;

import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.seleniumexpress.lc.formatter.PhoneNoFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.seleniumexpress.lc.Controller", "com.seleniumexpress.lc.service"})
@PropertySource("classpath:mail.properties")
public class LoveCalcAppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;
	
	//using logger instead of sysout is the best practice. It helps to keep systematic record of logs
	Logger logger=Logger.getLogger(LoveCalcAppConfig.class.getName());
	
	// set up my view resolver
	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}

	@Bean
	public MessageSource messageSource() {

		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		return messageSource;
	}

	@Bean(name = "validator")
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean lvfb = new LocalValidatorFactoryBean();
		lvfb.setValidationMessageSource(messageSource());
		return lvfb;

	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		
		logger.info("-------getting host name ------"+env.getProperty("mail.host"));

		javaMailSenderImpl.setHost(env.getProperty("mail.host")); // host for gmail
		javaMailSenderImpl.setUsername(env.getProperty("mail.username"));
		javaMailSenderImpl.setPassword(env.getProperty("mail.password"));
		//javaMailSenderImpl.setPort(Integer.parseInt(env.getProperty("mail.port")));
        /*
         * The above line  is correct but when taking about best practices we should try to make our code simpler
         * so making our own function that would do the same work.
         * 
         */  
		
		javaMailSenderImpl.setPort(getProperty("mail.port"));
		
		Properties mailProperties=getmailProperty();
		
		javaMailSenderImpl.setJavaMailProperties(mailProperties);
		
	return javaMailSenderImpl;	
	}

	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		System.out.println("inside add formatter");
		registry.addFormatter(new PhoneNoFormatter());
	}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return validator();
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/cssresources/**").addResourceLocations("WEB-INF/css/");
	}
	
	
	
	public Integer getProperty(String key)
	{
		String prop=env.getProperty(key);
		return Integer.parseInt(prop);
	}
	
	
	
	private Properties getmailProperty() {
		//JavaMailSenderImpl javaMailSenderImpl=new JavaMailSenderImpl();
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		

		return mailProperties;
	}

}
