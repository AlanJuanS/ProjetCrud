package com.Schedule.crm.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
	public Optional<User> findById(Long id){
		Optional<User> obj = userRepository.findById(id);
		return obj;
		
	}
	public User salve(User user) {
		 return userRepository.save(user);
		
	}
	public void delete(long id) {
		userRepository.deleteById(id);
	}
	public void update(long response) {
		userRepository.existsById(response);
		
	}
	

}
