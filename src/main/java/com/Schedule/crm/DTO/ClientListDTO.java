package com.Schedule.crm.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.Schedule.crm.Entity.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientListDTO {
	
	private Long id;
	private String name;
	private String tell;

	public ClientListDTO (Client client) {
		super();
		this.id = client.getId();
		this.name = client.getName();
		this.tell = client.getTell();
		
	}
	public static List<ClientListDTO> convert(List<Client>client) {
		return client.stream().map(ClientListDTO :: new).collect(Collectors.toList());
		}
}
