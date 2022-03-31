package com.Schedule.crm.Entity;

import java.sql.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



import lombok.Data;

@Data
@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo nome obrigatorio")
	@Column(nullable = false,length = 255)
	private String name;
	
	@Column(length = 255)
	@NotEmpty(message = "Campo origin obrigatorio")
	
	private String origin;
	
	@NotNull(message = "Campo dateTimeCreate obrigatorio")
	private  Date dateTimeCreate;
	@NotBlank
	@Column(length = 255)
	@NotEmpty(message = "Campo description obrigatorio")
	private String description;
	
	@Column(length = 255)
	@NotNull(message = "Campo dateTimeUpdate obrigatorio" )
	private Date dateTimeUpdate;
	
	@Column(length = 255)
	@NotEmpty(message = "Campo searchlmmobile obrigatorio")
	@NotNull
	private String searchlmmobile;
	
	@Column(length = 15)
	@NotEmpty(message = "Campo tell obrigatorio")
	@NotNull
	private String tell;
	
	@NotEmpty(message = "campo idUser obrigatorio")
	@NotNull
	private String idUser;	
}
