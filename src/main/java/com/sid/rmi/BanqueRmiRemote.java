package com.sid.rmi;

import java.rmi.RemoteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sid.entities.Compte;
import com.sid.metier.ICompteMetier;
import com.sid.metier.IOperationMetier;

@Component("myRmiService")
public class BanqueRmiRemote implements IBanqueRmiRemote {
	@Autowired
	private ICompteMetier compteMetier;
	@Autowired
	private IOperationMetier operationMetier;
	
	@Override
	public Compte saveCompte(Compte cp) throws RemoteException {
		// TODO Auto-generated method stub
		return compteMetier.saveCompte(cp);
	}

	@Override
	public Compte getCompte(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return compteMetier.getCompte(code);
	}

	@Override
	public boolean verser(String code, double montant, Long codeEmp) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.verser(code, montant, codeEmp);
	}

	@Override
	public boolean retirer(String code, double montant, Long codeEmp) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.retirer(code, montant, codeEmp);
	}

	@Override
	public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.virement(cpte1, cpte2, montant, codeEmp);
	}

}
