package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sid.entities.Compte;


public interface ICompteRepository extends JpaRepository<Compte, String>{

	@Query("Select c from Compte c where c.codeCompte like :x")
	public Compte getCompte(@Param("x") String codeCompte);
}
