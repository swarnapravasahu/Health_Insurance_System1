package com.healthInsurance.DAO;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthInsurance.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Serializable>{
	
	

}
