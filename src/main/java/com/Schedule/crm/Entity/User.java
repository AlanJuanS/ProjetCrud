package com.Schedule.crm.Entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;


import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	
	//@NotNull(message = "campo name obrigatorio")
	@Column
	private String name;
	
	@Column(unique = true)
	@CPF
	//@NotNull(message = "campo CPF obrigatorio")
	private String cpf;
	
	@Column
	//@NotNull
	private boolean primeiroAcesso;
	
	@Column(unique = true)
	@Email
	//@NotNull
	private String email;
		
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Client> client;	
	
}
