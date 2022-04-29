package com.Schedule.crm.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.Schedule.crm.DTO.UserCreateDTO;
import com.Schedule.crm.DTO.UserDTO;
import com.Schedule.crm.DTO.UserUpdateDTO;
import com.Schedule.crm.Entity.User;
import com.Schedule.crm.Repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service("UserService")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public List<User> getAlList(){
		return userRepository.findAll();
	}
	
	public UserDTO findById(Long id){
		User entity = userRepository.findById(id).get();
		UserDTO dto = new UserDTO(entity);
		return dto;
	}
	public User create(UserCreateDTO user) {
		return userRepository.save(objectMapper.convertValue(user,User.class));
		
	}
	
	public void delete(long id) {
		userRepository.deleteById(id);
	}
	
	public void update(long id) {
		User response = userRepository.findById(id).get();
		UserDTO dto = new UserDTO(response);
		}	
	public User update(UserUpdateDTO user) {
		return userRepository.save(objectMapper.convertValue(user,User.class));
		
	}

	}
