package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Long>{

}
