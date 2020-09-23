package com.seleniumexpress.lc.Controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.seleniumexpress.api.CommunicationDTO;
import com.seleniumexpress.api.FeedbackDTO;
import com.seleniumexpress.api.Phone;
import com.seleniumexpress.api.UserInfoDTO;
import com.seleniumexpress.api.uuserInfoDTO;
import com.seleniumexpress.api.Propertyeditor.Namepropeditor;
import com.seleniumexpress.lc.service.LcAppService;
import com.seleniumexpress.lc.service.LcEmailServiceImpl;
import com.seleniumexpress.lc.validator.UserNameValidate;

@Controller
@SessionAttributes("userInfo")
public class LCAppController {
	
	

	@Autowired
	LcAppService lcappservice;

	

	@RequestMapping("/")
	public String showHomePage(/* @ModelAttribute("userInfo") */ Model model, UserInfoDTO uDTO) {
		// read the existing property by fetching it from dto
		UserInfoDTO userInfo = new UserInfoDTO();
		model.addAttribute("userInfo", userInfo);

		return "home-page";

	}

	@RequestMapping("/result-page")
	 /*public String showResultPage(@Valid UserInfoDTO userInfoDTO, Model model,
	 BindingResult result)  */
	public String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDTO uDTO, BindingResult result, Model model) {

	/* If the no of parameters are more then not possible to write each argument of
	* a form so another approach is
	* used in which we create a class and use its obj userInfoDTO for the purpose
	* of data transfer
	* public String showResultPage(@RequestParam String uName, @RequestParam String
	*crushName,Model model)
	*/
	

		// Spring internally uses setter method to get the value of userName and
		// crushName

		// model.addAttribute("userName",uName);
		// model.addAttribute("crushName",crushName);

		// model.addAttribute("userName", userInfoDTO);

		System.out.println(uDTO.isTermcondition()); 

		if (result.hasErrors()) {
			List<ObjectError> allerror = result.getAllErrors();
			for (ObjectError temp : allerror) {
				System.out.println(temp); }
				return "home-page";
			}
		// it will completely create and manage cookies behind the scene.
		/*
		 * HttpSession session= request.getSession(); session.setAttribute("userName",
		 * uDTO.getuName());
		 */

		/*
		 *  we write a service which will calculate the love percent between username and crushname
		 */ 
		

		String finalresult = lcappservice.calculatelove(uDTO.getuName(), uDTO.getCrushName());
		model.addAttribute("appresult",finalresult);
		
	
		 
			
		return "next-page";

	}

	@RequestMapping("/register")
	public String getRegisteredPage(@Valid @ModelAttribute("userdetail") uuserInfoDTO dto, BindingResult result) {
		System.out.println("in registration page");

		// load the save user data from the database

		Phone phone = new Phone();
		phone.setCountryCode("91");
		phone.setUserNumber("7568230352");
		CommunicationDTO communicationDTO = new CommunicationDTO();
		communicationDTO.setPhone(phone);

		dto.setCommunicationDTO(communicationDTO);
		return "Register-page";
	}

	@RequestMapping("/showregister")
	public String getresultregister(@Valid @ModelAttribute("userdetail") uuserInfoDTO dto, BindingResult result) {

		System.out.println("in show  registration page");

		String nn = dto.getuName();
		System.out.println("Name is|" + nn + "|");

		if (result.hasErrors()) {
			List<ObjectError> allerror = result.getAllErrors();
			for (ObjectError temp : allerror) {
				System.out.println(temp);
			}
			// System.out.println("error in my form");
			return "Register-page";
		}

		// dto.setuName("nayana123");

		// save the dto object in our database
		return "showregister";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("inside init binder");
		// binder.setDisallowedFields("user");

//StringTrimmerEditor editor=new StringTrimmerEditor(false);
		// binder.registerCustomEditor(String.class, "uName", editor);

		Namepropeditor editor = new Namepropeditor();
		binder.registerCustomEditor(String.class, "uName", editor);

		// UserNameValidate validator=new UserNameValidate();
		// binder.addValidators(new UserNameValidate());

	}

	
	
}
