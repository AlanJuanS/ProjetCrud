package com.Schedule.crm.DTO;

import com.Schedule.crm.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {

	
	
	private String name;
	private String cpf;
	private boolean primeiroAcesso;
	private String email;
	
	public UserCreateDTO(User user) {
		super();
		this.name = user.getName();
		this.cpf = user.getCpf();
		this.primeiroAcesso = user.isPrimeiroAcesso();
		this.email = user.getEmail();
	}

	
	
}
