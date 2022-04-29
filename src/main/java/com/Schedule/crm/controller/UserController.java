package com.Schedule.crm.controller;


import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletSecurityElement;
import javax.validation.Valid;


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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Schedule.crm.DTO.ClientFindyByIdDTO;
import com.Schedule.crm.DTO.UserCreateDTO;
import com.Schedule.crm.DTO.UserDTO;
import com.Schedule.crm.DTO.UserFindyByIdDTO;
import com.Schedule.crm.DTO.UserListDTO;
import com.Schedule.crm.DTO.UserUpdateDTO;
import com.Schedule.crm.Entity.User;
import com.Schedule.crm.service.UserService;




@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@GetMapping
	public List<UserListDTO> getAlList(){
		List<User> user = userService.getAlList();
		return UserListDTO.convert(user);
	}
	
	@GetMapping(value = "/{id}")
	public UserDTO getById( @PathVariable Long id) {
		UserDTO dto = userService.findById(id);
		//if(!user.isPresent()) {
		//	return ResponseEntity.notFound().build();
		
//	}
	//	return ResponseEntity.ok().body(user.get());	
		return dto;
	}
	

	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public ResponseEntity<UserDTO> create(@RequestBody @Valid UserDTO user){
		URI uri = ServletUriComponentsBuilder	
				.fromCurrentRequest().path("/{id}").buildAndExpand(userService.create(user).getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
				
	@DeleteMapping("/{id}")
	public String delete(@PathVariable long id) {
		UserDTO user = userService.findById(id);
		//if(!user.isPresent()) {
		//	return "Usuario não encontrado";
		//}
	//	userService.delete(id);
		return "deletado com sucesso";
	}
	
	@PutMapping
	public String update(@RequestBody UserDTO response) {
		UserDTO dto = userService.findById(response.getId());
		//if(!user.isPresent()) {
		//	return "Usuario  não encontrado";s
		//}
	User save = userService.update(response);
	// return "atulizado com sucesso";
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

