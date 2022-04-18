package com.Schedule.crm.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Schedule.crm.DTO.UserDTO;
import com.Schedule.crm.Entity.User;
import com.Schedule.crm.Repository.UserRepository;

@Component
@Service("UserService")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAlList(){
		return userRepository.findAll();
	}
	
	public UserDTO findById(Long id){
		User entity = userRepository.findById(id).get();
		UserDTO dto = new UserDTO(entity);
		return dto;
	}
	
	public User salve(UserDTO user) {
		 return userRepository.save(user);	
	}
	
	public void delete(long id) {
		userRepository.deleteById(id);
	}
	
	public void update(long id) {
		User response = userRepository.findById(id).get();
		UserDTO dto= new UserDTO(response);
	}
	

}
