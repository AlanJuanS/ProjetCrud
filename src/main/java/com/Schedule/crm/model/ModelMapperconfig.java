package com.Schedule.crm.model;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperconfig {
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
		
	}

}
