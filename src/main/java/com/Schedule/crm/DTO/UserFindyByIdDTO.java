package com.Schedule.crm.DTO;

import com.Schedule.crm.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
public class UserFindyByIdDTO {

	
	
	
	private  Long id;
	private String name;
	private String cpf;
	private boolean primeiroAcesso;
	private String email;
	
	
	public UserFindyByIdDTO(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.cpf = user.getCpf();
		this.primeiroAcesso = user.isPrimeiroAcesso();
		this.email = user.getEmail();
	}

	
}
