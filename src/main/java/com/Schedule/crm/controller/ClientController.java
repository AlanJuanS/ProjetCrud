package com.Schedule.crm.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Schedule.crm.Repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public List<Client> listar() {
		return clientRepository.findAll();
	}
	@GetMapping("/{id}")
	public Client consult(@PathVariable Long id) {
		 return clientRepository.findById(id).get();	
	}
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public Client add(@RequestBody Client client) {
		 return clientRepository.save(client);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		clientRepository.deleteById(id);
	}
	@PutMapping
	public Client update(@RequestBody Client client) {
		return clientRepository.save(client);
		
	}
	
}
