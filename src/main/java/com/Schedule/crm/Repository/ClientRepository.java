package com.Schedule.crm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Schedule.crm.controller.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}
