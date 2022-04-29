package com.Schedule.crm.controller;


import java.net.URI;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.Schedule.crm.DTO.ClientCreateDTO;
import com.Schedule.crm.DTO.ClientFindyByIdDTO;
import com.Schedule.crm.DTO.ClientListDTO;
import com.Schedule.crm.DTO.ClientUpdateDTO;
import com.Schedule.crm.Entity.Client;
import com.Schedule.crm.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;




@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@GetMapping
	public List<ClientListDTO>clientDTOList() {
	  List<Client> client = clientService.ClientListDTO();
	  return ClientListDTO.convert(client);
	}
	
	@GetMapping(value = "/{id}")
	public  ClientFindyByIdDTO getById(@PathVariable Long id) {
		ClientFindyByIdDTO dto = clientService.findById(id);
		//if(!cliente.isPresent()) {
		//	return ResponseEntity.notFound().build();
		//}
	//	return ResponseEntity.ok().body(cliente.get());	
		return dto;
	}
	
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public ResponseEntity< ClientCreateDTO> create(@RequestBody  ClientCreateDTO client) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(clientService.create(client).getId()).toUri();
		return  ResponseEntity.created(uri).body(client);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable long id) {
		ClientFindyByIdDTO dto = clientService.findById(id);
		//if (!dto.isPresent()) {
			//return "cliente nao encontrado";
		//}
		clientService.delete(id);
	   return "deletado com sucesso";
	   
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientUpdateDTO> update(@PathVariable long id, @RequestBody ClientUpdateDTO client) {
		client.setId(id);
		Client newClient = clientService.update(client);
		return ResponseEntity.ok().body(objectMapper.convertValue(newClient, ClientUpdateDTO.class));
		
	}
	/*@PutMapping
	public String update( @RequestBody ClientDTO response) {
		 clientService.update(response);
		return "atualizado com sucesso";
		
	}*/

//	@PutMapping
//	public String update(@RequestBody ClientUpdateDTO response) {
//	clientService.update(response);
//	   return "atualizado com sucesso";	 
	   
//}
	
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
	
	

