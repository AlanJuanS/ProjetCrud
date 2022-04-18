package com.Schedule.crm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Schedule.crm.DTO.UserDTO;
import com.Schedule.crm.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	User save(UserDTO user);

}
