package com.sid.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sid.entities.Compte;
import com.sid.metier.ICompteMetier;

@RestController
public class CompteRestService {
	
	@Autowired
	private ICompteMetier compteMetier;
	
	@RequestMapping(value="/comptes", method=RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte c) {
		return compteMetier.saveCompte(c);
	}
	@RequestMapping(value="/comptes/{code}", method=RequestMethod.GET)
	public Compte getCompte(@PathVariable String code) {
		return compteMetier.getCompte(code);
	}
	
	

}
