package com.healthInsurance.DAO;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthInsurance.entity.RegisterEntity;

public interface RegisterRepository extends JpaRepository<RegisterEntity, Serializable>  {

	
}
