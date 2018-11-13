package com.sid.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sid.dao.ICompteRepository;
import com.sid.entities.Compte;

@Service
public class CompteMetier implements ICompteMetier{
	
	@Autowired
	private ICompteRepository compteRepository;

	@Override
	public Compte saveCompte(Compte c) {
		// TODO Auto-generated method stub
		c.setDateCreation(new Date());
		return compteRepository.save(c);
	}

	@Override
	public Compte getCompte(String code) {
		// TODO Auto-generated method stub
		return compteRepository.getCompte(code);
	}

	



	

}
