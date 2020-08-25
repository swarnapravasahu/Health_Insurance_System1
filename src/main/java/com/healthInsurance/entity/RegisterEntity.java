package com.healthInsurance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="hi_register")
public class RegisterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="REGIS_ID")
	private Integer registId;
	
	@Column(name="FIRST_NAME")
	private String fsName;
	
	@Column(name="LAST_NAME")
	private String lsName;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="ROLE")
	private String role;	
	
	@Column(name="ACC_STATUS")
    private Boolean accStatus;
	
	@Column(name="IS_DELETED")
	private Boolean isDeleted;
}
