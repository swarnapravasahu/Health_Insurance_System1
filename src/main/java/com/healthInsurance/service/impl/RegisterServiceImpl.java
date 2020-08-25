package com.healthInsurance.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthInsurance.DAO.RegisterRepository;
import com.healthInsurance.DAO.RoleRepository;
import com.healthInsurance.entity.RegisterEntity;
import com.healthInsurance.entity.RoleEntity;
import com.healthInsurance.model.RegisterModel;
import com.healthInsurance.service.RegisterServiceI;

@Service
public class RegisterServiceImpl implements RegisterServiceI{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	RegisterRepository registerRepository;

	@Override
	public Map<Integer, String> getRoles() {	
		
		Map<Integer,String> map = new HashMap();
		
		List<RoleEntity> findAll = roleRepository.findAll();
		for(RoleEntity entity:findAll) {		
			map.put(entity.getRole_id(), entity.getRole_name());
			
		}			
			return map;			
		}

	@Override
	public RegisterModel saveData(RegisterModel register) {
		
       RegisterModel model = new RegisterModel();
       
      RegisterEntity entity = new RegisterEntity();
      
      System.out.println("In ServiceImpl :register  ******"+register);
      BeanUtils.copyProperties(register, entity);
     
      System.out.println("In ServiceImpl :entity  ******"+entity);
      
       RegisterEntity save = registerRepository.save(entity);
       
       BeanUtils.copyProperties(save, model);
       
		return model;
	}

	@Override
	public List<RegisterModel> getAllRegisterDetails() {
		
		RegisterModel model = new RegisterModel();
		
		List<RegisterEntity> findAll = registerRepository.findAll();
		List<RegisterModel> registerList = new ArrayList();	
		
		for(RegisterEntity entity:findAll) {
			model = new RegisterModel();
			BeanUtils.copyProperties(entity, model);
			Optional<RoleEntity> findById = roleRepository.findById(Integer.valueOf(entity.getRole()));
			model.setRole(findById.get().getRole_name());
            registerList.add(model);
			
		}		
		
		return registerList;
	}

	@Override
	public RegisterModel getDataById(Integer id) {
		Optional<RegisterEntity> findById = registerRepository.findById(id);
		RegisterModel model = new RegisterModel();
		BeanUtils.copyProperties(findById.get(), model);
		
		return model;
	}
		
}
