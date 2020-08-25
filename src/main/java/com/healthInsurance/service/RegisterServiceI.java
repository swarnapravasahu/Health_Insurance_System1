package com.healthInsurance.service;

import java.util.List;
import java.util.Map;

import com.healthInsurance.model.RegisterModel;

public interface RegisterServiceI {

	public Map<Integer,String> getRoles();
	
	public RegisterModel saveData(RegisterModel register) ;
	
	public List<RegisterModel> getAllRegisterDetails();
	
	public RegisterModel getDataById(Integer id);
		
		
}
