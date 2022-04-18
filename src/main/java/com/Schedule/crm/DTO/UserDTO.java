package com.Schedule.crm.DTO;



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
public class UserDTO {
	
	private  Long id;
	private String name;
	private String cpf;
	private boolean primeiroAcesso;
	private String email;

	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.name =user.getName() ;
		this.cpf = user.getCpf();
		this.primeiroAcesso = user.isPrimeiroAcesso();
		this.email = user.getEmail();
	}
	
	public static List<UserDTO> convert(List<User>user) {
		return user.stream().map(UserDTO:: new).collect(Collectors.toList());
	}
}
		
		

