package com.Schedule.crm.DTO;

import java.util.List;
import java.util.stream.Collectors;


import com.Schedule.crm.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListDTO {
	
	
	private String name;
	private String email;
	
	public UserListDTO(User user) {
		super();
		this.name = user.getName();
		this.email = user.getEmail();
	}
	
	public static List<UserListDTO> convert(List<User>user) {
		return user.stream().map(UserListDTO :: new).collect(Collectors.toList());
	}
	
}

