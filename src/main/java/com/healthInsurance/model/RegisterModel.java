package com.healthInsurance.model;

import lombok.Data;

@Data
public class RegisterModel {
	
    private Integer registId;
	
	private String fsName;
	
	private String lsName;
	
	private String emailId;
	
	private String password;
	
	private String gender;
	
	private String role;
	
	private Boolean accStatus;
	
	private Boolean isDeleted;
	
}
