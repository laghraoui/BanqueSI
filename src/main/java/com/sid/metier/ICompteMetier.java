package com.sid.metier;

import com.sid.entities.Compte;

public interface ICompteMetier {
	
	public Compte saveCompte(Compte c);
	public Compte getCompte(String code);

}
