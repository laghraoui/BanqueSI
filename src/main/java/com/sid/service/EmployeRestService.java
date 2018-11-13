package com.sid.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sid.entities.Employe;
import com.sid.metier.IEmployeMetier;

@RestController
public class EmployeRestService {
	
	@Autowired
	private IEmployeMetier employeMetier;
	
	@RequestMapping(value="/employes", method=RequestMethod.POST)
	public Employe saveEmploye(@RequestBody Employe e) {
		// TODO Auto-generated method stub
		return employeMetier.saveEmploye(e);
	}
	
	@RequestMapping(value="/employes", method=RequestMethod.GET)
	public List<Employe> listEmploye() {
		// TODO Auto-generated method stub
		return employeMetier.listEmploye();
	}

}
