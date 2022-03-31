package com.Schedule.crm.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.Schedule.crm.Entity.User;
import com.Schedule.crm.service.UserService;




@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getAlList(){
		return userService.getAlList();
	}
	@GetMapping("/{id}")
	public ResponseEntity <User> getById( @PathVariable long id) {
		Optional<User> user = userService.findById(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		
		}
		return ResponseEntity.ok().body(user.get());	
	}
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public User post(@RequestBody @Valid User response) {
		 return userService.salve(response);	
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable long id) {
		Optional<User> user = userService.findById(id);
		if(!user.isPresent()) {
			return "Usuario não encontrado";
		}
		userService.delete(id);
		return "deletado com sucesso";
	}
	@PutMapping
	public String update(@RequestBody User response) {
		Optional<User> user= userService.findById(response.getId());
		if(!user.isPresent()) {
			return "Usuario  não encontrado";
		}
	User save = userService.salve(response);
	 return "atulizado com sucesso";
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationException(MethodArgumentNotValidException ex){
		Map<String,String>errors= new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) ->{
			String fieldName =((FieldError) error).getField();
			String errorsMessage = ( error).getDefaultMessage();
			errors.put(fieldName, errorsMessage);
		});		
		return errors;
		}
	}

