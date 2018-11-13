package com.sid.metier;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sid.dao.ICompteRepository;
import com.sid.dao.IEmployeRepository;
import com.sid.dao.IOperationRepository;
import com.sid.entities.Compte;
import com.sid.entities.Employe;
import com.sid.entities.Operationn;
import com.sid.entities.Retrait;
import com.sid.entities.Versement;

@Service
public class OperationMetier implements IOperationMetier{
	
	@Autowired
	private IOperationRepository operationRepository;
	@Autowired
	private ICompteRepository compteRepository;
	@Autowired
	private IEmployeRepository employeRepository;
	
	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.getOne(code);
		Employe emp = employeRepository.getOne(codeEmp);
		Operationn o=new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(emp);
		
		operationRepository.save(o);
		
		cp.setSolde(cp.getSolde()+montant);
		
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.getOne(code);
		
		if(cp.getSolde()<montant)
			throw new RuntimeException("Solde Insuffisant ! Rak ghadi fel khessraaan a hmmadi");
		
		Employe emp = employeRepository.getOne(codeEmp);
		Operationn o=new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(emp);
		
		operationRepository.save(o);
		
		cp.setSolde(cp.getSolde()-montant);
		return true;
	}

	@Override
	@Transactional
	public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) {
		
		retirer(cpte1, montant, codeEmp);
		verser(cpte2, montant, codeEmp);
		
		return true;
	}

	@Override
	public PageOperation getOperation(String codeCompte, int page, int size) {
		Page<Operationn> ops=operationRepository.getOperations
				(codeCompte, new PageRequest(page, size));
		PageOperation pOp=new PageOperation();
		pOp.setOperations(ops.getContent());
		pOp.setNombreOperations(ops.getNumberOfElements());
		pOp.setPage(ops.getNumber());
		pOp.setTotalPages(ops.getTotalPages());
		pOp.setTotalOperations((int)ops.getTotalElements());
		return pOp;
	}

}
