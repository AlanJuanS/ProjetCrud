package com.Schedule.crm.DTO;

import java.sql.Date;

import com.Schedule.crm.Entity.Client;
import com.Schedule.crm.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientUpdateDTO {
	
	private Long id;	
	private String name;
	private String origin;
	private  Date dateTimeCreate;
	private String description;
	private Date dateTimeUpdate;
	private String searchlmmobile;	
	private String tell;
	
	private User user;
	

	public ClientUpdateDTO(Client client) {
		this.id = client.getId();
		this.name = client.getName();
		this.origin = client.getOrigin();
		this.dateTimeCreate =client.getDateTimeCreate();
		this.description =client.getDescription();
		this.dateTimeUpdate =client.getDateTimeUpdate();
		this.searchlmmobile =client.getSearchlmmobile();
		this.tell = client.getTell();
		this.user = client.getUser();
	}
	
	

}
