package com.seleniumexpress.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalcAppInitialiser //implements WebApplicationInitializer 
{

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		// create a dispatcher servlet
        
		//when using configuration xml file
		//XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
		//webApplicationContext.setConfigLocation("classpath:mybeans.xml");
		
		
		//replacing config xml file with java config file
		AnnotationConfigWebApplicationContext webApplicationContext=new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalcAppConfig.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		// register dispatcher servlet with servlet context object
		// Dynamic is an interface inside ServletRegistration Interface
		ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("dadFrontcontroller", dispatcherServlet);
		myCustomDispatcherServlet.setLoadOnStartup(1);
		myCustomDispatcherServlet.addMapping("/");

	}

}
