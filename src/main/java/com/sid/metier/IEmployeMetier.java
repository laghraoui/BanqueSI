package com.sid.metier;

import java.util.List;

import com.sid.entities.Employe;

public interface IEmployeMetier {
	
	public Employe saveEmploye(Employe e);
	public List<Employe> listEmploye();

}
