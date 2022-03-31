package com.Schedule.crm.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Schedule.crm.Entity.Client;
import com.Schedule.crm.Repository.ClientRepository;

@Component
@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAll(){
		return clientRepository.findAll();
	}
	
	public Optional<Client> findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		return obj;
	}
	
	public Client salve (Client client) {
		return clientRepository.save(client);
	}
	
	public void delete(long id) {
	  clientRepository.deleteById(id);
	}
	
	public void update(Long response) {
		  clientRepository.existsById(response);
	}		
}

