package com.sid.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sid.entities.Compte;
import com.sid.metier.ICompteMetier;
import com.sid.metier.IOperationMetier;
import com.sid.metier.PageOperation;

@Component
@WebService
public class BanqueSoapService {
	
	@Autowired
	private ICompteMetier compteMetier;
	@Autowired
	private IOperationMetier operationMetier;
	
	@WebMethod
	public Compte getCompte(@WebParam(name="code") String code) {
		return compteMetier.getCompte(code);
	}
	@WebMethod
	public boolean verser(@WebParam(name="code") String code,
			@WebParam(name="montant") double montant,@WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.verser(code, montant, codeEmp);
	}
	@WebMethod
	public boolean retirer(@WebParam(name="code") String code,
			@WebParam(name="montant") double montant,@WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.retirer(code, montant, codeEmp);
	}
	@WebMethod
	public boolean virement(@WebParam(name="cpte1") String cpte1,
			@WebParam(name="cpte2") String cpte2,@WebParam(name="montant") double montant,
			@WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.virement(cpte1, cpte2, montant, codeEmp);
	}
	@WebMethod
	public PageOperation getOperation(@WebParam(name="codeCompte") String codeCompte,
			@WebParam(name="page") int page,@WebParam(name="size") int size) {
		return operationMetier.getOperation(codeCompte, page, size);
	}

}
