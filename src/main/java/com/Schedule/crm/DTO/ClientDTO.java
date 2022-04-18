package com.Schedule.crm.DTO;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;



import com.Schedule.crm.Entity.Client;
import com.Schedule.crm.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

	private Long id;
	private String name;
	private String tell;
	private User user;
	
	
	public ClientDTO(Client client) {
		super();
		this.id = client.getId();
		this.name = client.getName();
		this.tell = client.getTell();
		this.user = client.getUser();
	}

	public static List<ClientDTO> convert(List<Client>client) {
		return client.stream().map(ClientDTO:: new).collect(Collectors.toList());
		
	}	
	
		
}

