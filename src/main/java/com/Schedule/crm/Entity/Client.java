package com.Schedule.crm.Entity;

import java.sql.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;




import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "client")
@Accessors(chain = true)
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo nome obrigatorio")
	@Column(nullable = false,length = 255)
	private String name;
	
	@Column(length = 255)
	//@NotEmpty(message = "Campo origin obrigatorio")
	private String origin;
	
	@Column
	private  Date dateTimeCreate;
	
	@Column(length = 255)
	//@NotEmpty(message = "Campo description obrigatorio")
	private String description;
	
	@Column(length = 255)
	//@NotNull(message = "Campo dateTimeUpdate obrigatorio" )
	private Date dateTimeUpdate;
	
	@Column(length = 255)
	//@NotEmpty(message = "Campo searchlmmobile obrigatorio")
	private String searchlmmobile;
	
	@Column(length = 15)
	@NotEmpty(message = "Campo tell obrigatorio")
	private String tell;
	
	//@NotEmpty
	@ManyToOne
	@JoinColumn(name = "user_Id", nullable = false)
	private User user;
}
