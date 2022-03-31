package com.Schedule.crm.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



import lombok.Data;

@Data
@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	
	@NotEmpty(message = "campo name obrigatorio")
	@Column
	private String name;
	
	@Column
	@org.hibernate.validator.constraints.br.CPF
	@NotEmpty(message = "campo CPF obrigatorio")
	private String cpf;
	
	@Column
	@NotNull
	private boolean primeiroAcesso;
	
	@Column
	@Email
	@NotEmpty
	private String email;
	
	
	

}
