package com.sid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sid.metier.IOperationMetier;
import com.sid.metier.PageOperation;

@RestController
public class OperationRestService {
	
	@Autowired
	private IOperationMetier operationmetier;
	
	@RequestMapping(value="/operations",method=RequestMethod.GET)
	public PageOperation getOperation(@RequestParam String codeCompte, 
									  @RequestParam int page, 
									  @RequestParam int size) {
		return operationmetier.getOperation(codeCompte, page, size);
	}
	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public boolean verser(@RequestParam String code, @RequestParam double montant, @RequestParam Long codeEmp) {
		return operationmetier.verser(code, montant, codeEmp);
	}
	@RequestMapping(value="/retrait",method=RequestMethod.PUT)
	public boolean retirer(@RequestParam String code,@RequestParam double montant,@RequestParam Long codeEmp) {
		return operationmetier.retirer(code, montant, codeEmp);
	}
	@RequestMapping(value="/virement",method=RequestMethod.PUT)
	public boolean virement(@RequestParam String cpte1,@RequestParam String cpte2,@RequestParam double montant,@RequestParam Long codeEmp) {
		return operationmetier.virement(cpte1, cpte2, montant, codeEmp);
	}
	
	

}
