package com.healthInsurance.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.healthInsurance.model.RegisterModel;
import com.healthInsurance.service.RegisterServiceI;

@Controller
public class AdminController {
	
	@Autowired
	RegisterServiceI registerServiceI;
	
	
	@GetMapping(value= {"/","/home"})
	public String getHomePage(Model model) {
		
		return "Home";
	}
	
	@GetMapping(value= {"/register","/register/{id}"})
	public String loadRegisterPage(@PathVariable("id") Optional<Integer> id,Model model) {
				
		RegisterModel register = new RegisterModel();
		Map<Integer, String> roles = registerServiceI.getRoles();
		model.addAttribute("roleMap", roles);
		
		if(!id.isPresent()) {		
		model.addAttribute("register", register);	
		}
		else {
			register =registerServiceI.getDataById(id.get());
			model.addAttribute("register", register);
		}
		
		
		
		return "register";
	}
	
	@PostMapping(value="/registation")
	public String saveRegisterData(@ModelAttribute RegisterModel register,Model model) {
		
		System.out.println("In side Controller :"+register);
		RegisterModel saveData = registerServiceI.saveData(register);
		String msg=null;
		
		if(saveData !=null) {
			msg = "Registration Successfully !" ;
		}
		else {
			msg =" Something went wrong , please try again";
		}		
				
		model.addAttribute("scsMsg",msg);
		return "success";
	}
	
	@GetMapping(value= "/view")
	public String getViewPage(Model model) {
		
		List<RegisterModel> list = registerServiceI.getAllRegisterDetails();
		
		model.addAttribute("list", list);
		
		return "view";
	}
	
	
	
	
	
	
	
}
