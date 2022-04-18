package com.Schedule.crm.controller;


import java.net.URI;
import java.rmi.server.ServerCloneException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.validation.Valid;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.aspectj.apache.bcel.generic.InstructionConstants.Clinit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

import com.Schedule.crm.DTO.ClientDTO;
import com.Schedule.crm.Entity.Client;
import com.Schedule.crm.service.ClientService;

import lombok.experimental.StandardException;



@RestController
@RequestMapping("/client")
public class ClientController {
	
	

	@Autowired
	ClientService clientService;
	
	

	@GetMapping
	public List<ClientDTO> getAll() {
	  List<Client> client = clientService.getAll();
	  return ClientDTO.convert(client);
	}
	
	@GetMapping(value = "/{id}")
	public  ClientDTO getById(@PathVariable Long id) {
		ClientDTO dto = clientService.findById(id);
		//if(!cliente.isPresent()) {
		//	return ResponseEntity.notFound().build();
		//}
	//	return ResponseEntity.ok().body(cliente.get());	
		return dto;
	}
	
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public ResponseEntity<ClientDTO> post(@RequestBody @Valid ClientDTO client) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(clientService.create(client).getId()).toUri();
		return  ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable long id) {
		ClientDTO dto = clientService.findById(id);
		//if (!dto.isPresent()) {
			//return "cliente nao encontrado";
		//}
		clientService.delete(id);
	   return "deletado com sucesso";
	   
	}

	
	@PutMapping
	public String update(@RequestBody ClientDTO response) {
		clientService.update(response);
	   return "atualizado com sucesso";	   
	}
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName =((FieldError) error).getField();
			String errorsMessage = ( error).getDefaultMessage();
			errors.put(fieldName, errorsMessage);
		});
		
		return errors;
	}
	
		
	}
	
	

