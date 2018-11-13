package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.entities.Employe;

public interface IEmployeRepository extends JpaRepository<Employe, Long> {

}
