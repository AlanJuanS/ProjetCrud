package com.Schedule.crm.service;



import java.util.List;
import java.util.Optional;

import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.apache.catalina.mapper.Mapper;
import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Schedule.crm.DTO.ClientDTO;
import com.Schedule.crm.DTO.UserDTO;
import com.Schedule.crm.Entity.Client;
import com.Schedule.crm.Entity.User;
import com.Schedule.crm.Repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
		
	public List<Client> getAll(){
		return clientRepository.findAll();
	}
	
	public ClientDTO findById(Long id) {
		Client entity = clientRepository.findById(id).get();
		ClientDTO dto = new ClientDTO(entity);
		return dto;
	}
	
	
	public Client convertDtoForEntity(ClientDTO client) {
		 Client newClient = new Client();
		 newClient.setId(client.getId());
		 newClient.setName(client.getName());
		return newClient;
		
	}
	
	
	public Client create(ClientDTO clientDto) {
		UserDTO userDto = userService.findById(clientDto.getUser().getId());
		User user = objectMapper.convertValue(userDto,User.class);
		Client client = objectMapper.convertValue(clientDto,Client.class);
		client.setUser(user);
		return clientRepository.save(client);
	}
	
	public void delete(long id) {
	  clientRepository.deleteById(id);
	}
	
	public Client update(ClientDTO client) {
		ClientDTO clientDto = this.findById(client.getId());
		if(client != null) {			
			return clientRepository.save(objectMapper.convertValue(client,Client.class));
		}
		  return null;
	}		
}

